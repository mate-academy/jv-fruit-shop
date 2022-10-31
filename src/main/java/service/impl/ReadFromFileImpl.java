package service.impl;

import service.ReadFromFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private List<String> activitiesOfDay;

    public ReadFromFileImpl(){
        this.activitiesOfDay = new ArrayList<>();
    }

    @Override
    public List<String> readFormFile(String filePath) {
        try {
            this.activitiesOfDay = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("No such file found!");
        }
        activitiesOfDay.remove(0);
        return activitiesOfDay;
    }
}
