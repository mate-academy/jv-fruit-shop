package service.impl;

import model.FruitTransaction;
import service.TransactionDataParse;

public class TransactionDataParseImpl implements TransactionDataParse {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    public TransactionDataParseImpl() {
    }

    @Override
    public FruitTransaction parseTransaction(String line) {
        String[] tokens = line.split(SEPARATOR);
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid transaction line: " + line);
        }
        String operationCode = tokens[OPERATION_POSITION].trim();
        String fruit = tokens[FRUIT_POSITION].trim();
        int quantity = Integer.parseInt(tokens[QUANTITY_POSITION].trim());
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity value " + quantity);
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromCode(operationCode);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
