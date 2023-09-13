package service.impl;

import exception.InvalidDataException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.ConvertData;

public class ConvertDataImpl implements ConvertData {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Fruit> fruitList(List<String> inputInfo) {
        List<Fruit> fruitList = new ArrayList<>();
        for (String line : inputInfo) {
            String[] splitLine = line.split(SEPARATOR);
            if (!Character.isDigit(splitLine[QUANTITY_INDEX].charAt(OPERATION_INDEX))) {
                continue;
            }
            int quantity = Integer.parseInt(splitLine[QUANTITY_INDEX]);
            if (quantity < 0) {
                throw new InvalidDataException(
                        "Fruit quantity is not enough to process 'purchase' operation");
            }
            fruitList.add(new Fruit(splitLine[OPERATION_INDEX], splitLine[FRUIT_NAME_INDEX],
                    quantity));
        }
        return fruitList;
    }
}
