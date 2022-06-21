package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public Transaction.Operation getOperation(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return Transaction.Operation.getOperation(splittedCsvLine[OPERATION_INDEX]);
    }

    @Override
    public Fruit getFruit(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return new Fruit(splittedCsvLine[FRUIT_INDEX]);
    }

    @Override
    public Integer getQuantity(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return Integer.valueOf(splittedCsvLine[QUANTITY_INDEX]);
    }
}
