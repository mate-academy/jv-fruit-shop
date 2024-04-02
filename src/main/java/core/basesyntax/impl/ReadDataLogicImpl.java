package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.ReadDataLogic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReadDataLogicImpl implements ReadDataLogic {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;
    private DataBase database = new DataBase();

    @Override
    public Map<String, Integer> readDataFromFile(String path) {
        Map<String, Integer> map = database.getDb();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                String[] part = nextLine.split(",");
                String operation = part[INDEX_OF_OPERATION_TYPE];
                String fruit = part[INDEX_OF_FRUIT_TYPE];
                int quantity = Integer.parseInt(part[INDEX_OF_FRUIT_QUANTITY]);
                switch (operation) {
                    case "b":
                        map.put(fruit, quantity);
                        break;
                    case "s":
                        map.put(fruit, map.getOrDefault(fruit, 0) + quantity);
                        break;
                    case "p":
                        map.put(fruit, map.getOrDefault(fruit, 0) - quantity);
                        break;
                    case "r":
                        map.put(fruit, map.getOrDefault(fruit, 0) + quantity);
                        break;
                    default:
                        throw new RuntimeException("Invalid operation type" + operation);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path);
        }
        return map;
    }
}
