package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.OperationType;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> fruitList(List<String> inputInfo) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : inputInfo) {
            String[] splitLine = line.split(SEPARATOR);
            if (splitLine.length != 3) {
                continue; //and log or throw Exception
            }
            String operation = splitLine[OPERATION_INDEX].trim();
            String fruitName = splitLine[FRUIT_NAME_INDEX].trim();
            String quantity = splitLine[QUANTITY_INDEX].trim();
            if (!quantity.matches("\\d+")) {
                continue; //and log or throw Exception
            }
            if (operation.length() != 1 || !OperationType.ALL_TYPES.getName().contains(operation)) {
                continue; //and log or throw Exception
            }
            if (!operation.equals(OperationType.BALANCE.getName())) {
                if (!isNameValid(fruitTransactionList, fruitName)) {
                    continue; //and log or throw Exception
                }
            }
            if (operation.equals((OperationType.BALANCE.getName()))) {
                if (isNameValid(fruitTransactionList, fruitName)) {
                    continue; // and log or throw Exception
                }
            }
            fruitTransactionList.add(
                    new FruitTransaction(operation, fruitName, Integer.parseInt(quantity)));
        }
        return fruitTransactionList;
    }

    private boolean isNameValid(List<FruitTransaction> fruitTransactionList, String fruitName) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            if (fruitTransaction.getName().equals(fruitName)) {
                return true;
            }
        }
        return false;
    }
}
