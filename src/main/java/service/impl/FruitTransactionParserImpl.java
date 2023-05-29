package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SPLITTER_FIELD = ";";
    private static final int OPERATION_FIELD_NUMBER = 0;
    private static final int FRUIT_FIELD_NUMBER = 1;
    private static final int QUANTITY_FIELD_NUMBER = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> inputStoreActivities) {
        inputStoreActivities.remove(0);
        return inputStoreActivities.stream()
                .map(this::getTransactionRecordFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getTransactionRecordFromCsvRow(String line) {
        FruitTransaction.Operation operation;
        String[] dataFields = line.split(SPLITTER_FIELD);
        String fruit = dataFields[FRUIT_FIELD_NUMBER];
        int quantity = Integer.parseInt(dataFields[QUANTITY_FIELD_NUMBER]);
        switch (dataFields[0]) {
            case "s":
                operation = FruitTransaction.Operation.SUPPLY;
                break;
            case "p":
                operation = FruitTransaction.Operation.PURCHASE;
                break;
            case "r":
                operation = FruitTransaction.Operation.RETURN;
                break;
            default:
                operation = FruitTransaction.Operation.BALANCE;
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
