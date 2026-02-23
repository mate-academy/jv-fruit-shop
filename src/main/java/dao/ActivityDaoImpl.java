package dao;

import db.Storage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Activity;
import model.Type;

public class ActivityDaoImpl implements ActivityDao {
    private static final int TYPE_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<Activity> getActivities(String filePath) {
        List<Activity> activities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // пропускаємо header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);

                Activity activity = new Activity(
                        getType(data[TYPE_POSITION]),
                        data[FRUIT_NAME_POSITION],
                        Integer.parseInt(data[QUANTITY_POSITION])
                );

                activities.add(activity);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }

        return activities;
    }

    @Override
    public void saveActivities(String filePath) {
        Map<String, Integer> storage = Storage.getStorage();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("fruit,quantity");
            bw.newLine();

            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                bw.write(entry.getKey() + DELIMITER + entry.getValue());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + filePath, e);
        }
    }

    private Type getType(String type) {
        return switch (type) {
            case "b" -> Type.BALANCE;
            case "s" -> Type.SUPPLY;
            case "p" -> Type.PURCHASE;
            case "r" -> Type.RETURN;
            default -> throw new RuntimeException("Unknown activity type: " + type);
        };
    }
}
