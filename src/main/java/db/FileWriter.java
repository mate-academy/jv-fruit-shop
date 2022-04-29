package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    public void writeToFile(String pathName, StringBuilder report) {
        try {
            Files.write(Path.of(pathName), report.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write this file " + pathName, e);
        }
    }
}
