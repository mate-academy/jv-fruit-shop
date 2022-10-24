package core.basesyntax.service;

public class FruitTransaction {
    private static final int TRANSACTION_FORMAT_OPERATION_INDEX = 0;
    private static final int TRANSACTION_FORMAT_NAME_INDEX = 1;
    private static final int TRANSACTION_FORMAT_VALUE_INDEX = 2;
    private final Operation operation;
    private final String fruitName;
    private final Integer valueOfFruit;

    public FruitTransaction(String fromList) {
        String[] split = fromList.split(",");

        operation = getOperationByCharCode(split[TRANSACTION_FORMAT_OPERATION_INDEX]);
        fruitName = split[TRANSACTION_FORMAT_NAME_INDEX];
        valueOfFruit = Integer.valueOf(split[TRANSACTION_FORMAT_VALUE_INDEX]);
    }

    private Operation getOperationByCharCode(String code) {
        switch (code) {
            case "b": return Operation.BALANCE;
            case "s": return Operation.SUPPLY;
            case "p": return Operation.PURCHASE;
            case "r": return Operation.RETURN;
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
