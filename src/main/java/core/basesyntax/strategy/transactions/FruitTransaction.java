package core.basesyntax.strategy.transactions;

import core.basesyntax.strategy.Operation;

public class FruitTransaction {
    private static final int TRANSACTION_FORMAT_OPERATION_INDEX = 0;
    private static final int TRANSACTION_FORMAT_NAME_INDEX = 1;
    private static final int TRANSACTION_FORMAT_VALUE_INDEX = 2;
    private static final String CSV_FORMAT_SEPARATOR = ",";
    private final Operation operation;
    private final String fruitName;
    private final Integer valueOfFruit;

    public FruitTransaction(String fromList) {
        String[] split = fromList.split(CSV_FORMAT_SEPARATOR);

        operation = Operation.getOperationByCode(split[TRANSACTION_FORMAT_OPERATION_INDEX]);
        fruitName = split[TRANSACTION_FORMAT_NAME_INDEX];
        valueOfFruit = Integer.valueOf(split[TRANSACTION_FORMAT_VALUE_INDEX]);
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getValueOfFruit() {
        return valueOfFruit;
    }
}
