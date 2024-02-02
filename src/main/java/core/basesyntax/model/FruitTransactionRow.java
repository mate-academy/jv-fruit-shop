package core.basesyntax.model;

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

    public String toCsv() {
        return operation + "," + fruit + "," + quantity;
    }

    @Override
    public String toString() {
        return "FruitTransactionRow{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation of(String letter) {
            for (Operation action : Operation.values()) {
                if (action.getCode().equalsIgnoreCase(letter)) {
                    return action;
                }
            }
            throw new IllegalArgumentException("No operation with letter " + letter + " in enum");
        }

        public String getCode() {
            return code;
        }
    }
}