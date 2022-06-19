package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class TransactionParserImpl implements TransactionParser {
    final int OPERATION_INDEX = 0;
    final int FRUIT_INDEX = 1;
    final int QUANTITY_INDEX = 2;

    public Operation getOperation(String line) {
        if (line.equals("null")) {
            return null;
        }
        String[] splittedCsvLine = line.split(",");
        return Operation.getOperationFromString(splittedCsvLine[OPERATION_INDEX]);
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
