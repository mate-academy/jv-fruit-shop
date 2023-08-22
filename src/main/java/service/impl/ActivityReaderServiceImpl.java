package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Activity;
import model.ActivityType;
import service.ActivityReaderService;

public class ActivityReaderServiceImpl implements ActivityReaderService {
    @Override
    public List<Activity> readFromFile(String fileName) {
        List<Activity> activityList = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                data = line.split(",");
                activityList.add(new Activity(
                        ActivityType.fromCode(data[0]),
                        data[1],
                        Integer.parseInt(data[2]))
                );
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't find or read file", e);
        }

        return activityList;
    }
}

