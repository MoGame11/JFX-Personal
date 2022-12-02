package at.mogame11.javafxselfmade;

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

    public FileHandler() {

    }

    public boolean isCorrectInput(String userName, String userPassword) {
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
                if (Objects.equals(userPassword, fileHandler.password)) {
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
