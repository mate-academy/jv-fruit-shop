package service.impl;

import exception.InvalidDataException;
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
                throw new InvalidDataException("Invalid input data format: " + line);
            }
            String operation = splitLine[OPERATION_INDEX].trim();
            String fruitName = splitLine[FRUIT_NAME_INDEX].trim();
            int quantity = Integer.parseInt(splitLine[QUANTITY_INDEX].trim());
            if (operation.equals((OperationType.BALANCE.getName()))) {
                if (isFruitAlreadyStored(fruitTransactionList, fruitName)) {
                    throw new InvalidDataException("Balance for '" + fruitName
                            + "' is already set");
                }
            }
            fruitTransactionList.add(
                    new FruitTransaction(operation, fruitName, quantity));
        }
        return fruitTransactionList;
    }

    private boolean isFruitAlreadyStored(
            List<FruitTransaction> fruitTransactionList, String fruitName) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            if (fruitTransaction.getName().equals(fruitName)) {
                return true;
            }
        }
        return false;
    }
}
