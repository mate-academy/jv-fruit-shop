package impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.ParseDataService;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int CURRENT_LENGTH = 3;
    private static final String SEPARATOR = ",";

    @Override
    public List<Fruit> parseData(List<String> list) {
        validDataFromFile(list);
        List<Fruit> fruits = new ArrayList<>();
        for (String data : list) {
            String[] result = data.split(SEPARATOR);
            Fruit fruit = new Fruit(result[INDEX_OPERATION],
                    result[INDEX_OF_FRUIT_NAME],
                    Integer.parseInt(result[INDEX_OF_QUANTITY]));
            fruits.add(fruit);
        }
        return fruits;
    }

    private void validDataFromFile(List<String> list) {
        for (String data : list) {
            String[] dataFromFile = data.split(SEPARATOR);
            if (dataFromFile.length != CURRENT_LENGTH) {
                throw new RuntimeException("Invalid data in file, string must be 3 elements");
            }
            if (Integer.parseInt(dataFromFile[INDEX_OF_QUANTITY]) < 0) {
                throw new RuntimeException("Quantity can`t be negative!");
            }
        }
    }
}
