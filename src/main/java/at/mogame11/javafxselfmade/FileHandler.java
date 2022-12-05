package at.mogame11.javafxselfmade;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class FileHandler {
    private String userName;
    private String password;
    private static final Path PATH = Paths.get("src/main/resources/at/mogame11/javafxselfmade/userData.csv");
    private static final String HEADER_FOR_FILE = "UserName;firstName;name;password";

    public FileHandler() {
    }

    public static void init() {
        try {
            if (Files.notExists(PATH)){
                FileWriter fw = new FileWriter(PATH.toFile());
                fw.write(HEADER_FOR_FILE);
                fw.close();
            }
        }catch (IOException iox){
            System.err.println("Exception: "+iox);
        }
    }
    public static void writeFile(String userName, String password){
        int passHash = password.hashCode();
        String log = (userName+passHash);
        try {
            FileWriter fw = new FileWriter(PATH.toFile(), true);
            fw.write(log);
            fw.close();
        } catch (IOException ignored) {
        }
    }

    boolean isCorrectInput(String userName, String userPassword) {
        ArrayList<FileHandler> returner = new ArrayList<>();
        StringBuilder wholeFile = new StringBuilder("");
        try {
            for (final String line : Files.readAllLines(PATH)) {
                wholeFile.append(line).append("\n");
            }
        }catch (IOException ioException){
            System.err.println("Exception: " + ioException);
        }
        int index = wholeFile.indexOf("\n");
        String temp = wholeFile.substring(index + 1);

        while(!Objects.equals(temp, "")){
            int tempIndex = temp.indexOf("\n");
            String oneLine = temp.substring(0,tempIndex);
            returner.add(getDataFromLine(oneLine));
            if(temp.length()>=tempIndex+1) {
                temp = temp.substring(tempIndex + 1);
            }else {
                temp = "";
            }
        }
        for (FileHandler fileHandler : returner) {
            if (Objects.equals(userName, fileHandler.userName)) {
                if (Objects.equals(userPassword.hashCode(), Integer.parseInt(fileHandler.password))) {
                    return true;
                }
            }
        }
        return false;
    }
    FileHandler(String uN, String pW){
        this.userName = uN;
        this.password = pW;
    }

    private FileHandler getDataFromLine(String oneLine) {
        String[] temp = oneLine.split(";");
        String userName = temp[0];
        String password = temp[3];
        return new FileHandler(userName, password);
    }
}
