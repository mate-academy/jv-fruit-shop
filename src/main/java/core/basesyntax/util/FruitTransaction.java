package core.basesyntax.util;

import core.basesyntax.strategy.Operation;

public class FruitTransaction {
    private static final int TRANSACTION_FORMAT_OPERATION_INDEX = 0;
    private static final int TRANSACTION_FORMAT_NAME_INDEX = 1;
    private static final int TRANSACTION_FORMAT_VALUE_INDEX = 2;
    private static final String CSV_FORMAT_SEPARATOR = ",";
    private static final String BALANCE_CODE_CHAR = "b";
    private static final String SUPPLY_CODE_CHAR = "s";
    private static final String PURCHASE_CODE_CHAR = "p";
    private static final String RETURN_CODE_CHAR = "r";
    private final Operation operation;
    private final String fruitName;
    private final Integer valueOfFruit;

    public FruitTransaction(String fromList) {
        String[] split = fromList.split(CSV_FORMAT_SEPARATOR);

        operation = getOperationByCharCode(split[TRANSACTION_FORMAT_OPERATION_INDEX]);
        fruitName = split[TRANSACTION_FORMAT_NAME_INDEX];
        valueOfFruit = Integer.valueOf(split[TRANSACTION_FORMAT_VALUE_INDEX]);
    }

    private Operation getOperationByCharCode(String code) {
        switch (code) {
            case BALANCE_CODE_CHAR: return Operation.BALANCE;
            case SUPPLY_CODE_CHAR: return Operation.SUPPLY;
            case PURCHASE_CODE_CHAR: return Operation.PURCHASE;
            case RETURN_CODE_CHAR: return Operation.RETURN;
            default: throw new RuntimeException("Wrong csv format");
        }
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
