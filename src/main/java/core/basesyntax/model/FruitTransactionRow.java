package core.basesyntax.model;

import core.basesyntax.service.strategy.Operation;

public final class FruitTransactionRow {
    private static final String DATA_ROW_SEPARATOR = ",";
    private static final int DATA_ROW_OPERATION_INDEX = 0;
    private static final int DATA_ROW_FRUIT_NAME_INDEX = 1;
    private static final int DATA_ROW_QUANTITY_INDEX = 2;
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransactionRow(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public static FruitTransactionRow of(String dataRow) {
        String[] dataRowSplit = dataRow.split(DATA_ROW_SEPARATOR);
        Operation operation = Operation.of(dataRowSplit[DATA_ROW_OPERATION_INDEX]);
        int fruitQuantity = Integer.parseInt(dataRowSplit[DATA_ROW_QUANTITY_INDEX]);
        return new FruitTransactionRow(operation,
                dataRowSplit[DATA_ROW_FRUIT_NAME_INDEX], fruitQuantity);
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransactionRow{"
                + "operation=" + operation
                + ", fruit='" + fruit
                + ", quantity=" + quantity
                + '}';
    }
}
