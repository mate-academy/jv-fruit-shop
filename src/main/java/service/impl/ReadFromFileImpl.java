package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.ReadFromFile;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
     public List<String> readFormFile(String filePath) {
        try {
            List<String> activitiesOfDay = Files.readAllLines(Paths.get(filePath));
            return activitiesOfDay;
        } catch (IOException e) {
            throw new RuntimeException("No such file found!");
        }
    }
}
