package service.impl;

import service.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
            this.activitiesOfDay = Files.readAllLines(new File(filePath).toPath());
        } catch (IOException e) {
            throw new RuntimeException("No such file found!");
        }
        activitiesOfDay.remove(0);
        return activitiesOfDay;
    }
}
