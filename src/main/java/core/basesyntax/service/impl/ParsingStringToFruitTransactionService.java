package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parsing;

public class ParsingStringToFruitTransactionService implements Parsing {
    private static final String RUNTIME_EXCEPTION_MESSAGE = "can't parse this line";
    private static final String SPLITER  = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    @Override
    public FruitTransaction parse(String line) {
        String[] splitedLine = line.split(SPLITER);
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(splitedLine[INDEX_OF_OPERATION])) {
                return new FruitTransaction(operation,
                        splitedLine[INDEX_OF_FRUIT_NAME],
                        Integer.parseInt(splitedLine[INDEX_OF_QUANTITY]));
            }
        }
        throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE);
    }
}
