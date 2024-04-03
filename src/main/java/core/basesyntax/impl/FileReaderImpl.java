package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.FruitActivity;
import core.basesyntax.service.FileReaderInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderInterface {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;
    private static final String SEPARATOR = ",";
    private DataBase database = new DataBase();

    @Override
    public List<FruitActivity> readDataFromFile(String path) {
        List<FruitActivity> activities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                if (parts.length == 3) {
                    String activity = parts[INDEX_OF_OPERATION_TYPE];
                    String fruit = parts[INDEX_OF_FRUIT_TYPE];
                    int quantity = Integer.parseInt(parts[INDEX_OF_FRUIT_QUANTITY]);
                    activities.add(new FruitActivity(activity, fruit, quantity));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can'r read data from file " + path);
        }
        return activities;
    }
}
