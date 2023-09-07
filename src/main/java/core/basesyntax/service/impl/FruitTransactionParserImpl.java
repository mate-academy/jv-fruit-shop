package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public FruitTransaction parseTransaction(String line) {
        String[] separatedValues = line.split(SEPARATOR);
        return new FruitTransaction(assignOperation(separatedValues[OPERATION_INDEX]),
                separatedValues[FRUIT_INDEX],
                Integer.parseInt(separatedValues[AMOUNT_INDEX]));
    }

    private FruitTransaction.Operation assignOperation(String code) {
        for (FruitTransaction.Operation operation: FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation: \"" + code + "\" doesn't exists");
    }
}
