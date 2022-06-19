package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public Transaction.Operation getOperation(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return Transaction.Operation.getOperationFromString(splittedCsvLine[OPERATION_INDEX]);
    }

    public Fruit getFruit(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return new Fruit(splittedCsvLine[FRUIT_INDEX]);
    }

    public Integer getQuantity(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return Integer.valueOf(splittedCsvLine[QUANTITY_INDEX]);
    }
}
