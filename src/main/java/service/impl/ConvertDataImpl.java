package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.OperationType;
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
            if (splitLine.length != 3) {
                continue; //and log or throw Exception
            }
            String operation = splitLine[OPERATION_INDEX].trim();
            String fruitName = splitLine[FRUIT_NAME_INDEX];
            String quantity = splitLine[QUANTITY_INDEX];
            if (!quantity.matches("\\d+")) {
                continue; //and log or throw Exception
            }
            if (operation.length() != 1 || !OperationType.ALL_TYPES.getName().contains(operation)) {
                continue; //and log or throw Exception
            }
            if (!operation.equals(OperationType.BALANCE.getName())) {
                if (!isNameValid(fruitList, fruitName)) {
                    continue; //and log or throw Exception
                }
            }
            if (operation.equals((OperationType.BALANCE.getName()))) {
                if (isNameValid(fruitList, fruitName)) {
                    continue; // and log or throw Exception
                }
            }
            fruitList.add(new Fruit(operation, fruitName, Integer.parseInt(quantity)));
        }
        return fruitList;
    }

    private boolean isNameValid(List<Fruit> fruitList, String fruitName) {
        for (Fruit fruit : fruitList) {
            if (fruit.getName().equals(fruitName)) {
                return true;
            }
        }
        return false;
    }
}
