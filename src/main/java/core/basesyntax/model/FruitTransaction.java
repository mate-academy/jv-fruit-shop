package core.basesyntax.model;

public class FruitTransaction {
    private static final int INDEX_OF_OPERATION_IN_RECORD = 0;
    private static final int INDEX_OF_FRUIT_IN_RECORD = 1;
    private static final int INDEX_OF_QUANTITY_IN_RECORD = 2;

    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static FruitTransaction valueOf(String record) {
        record = record.trim();
        String[] fields = record.split(",");
        Operation operation = Operation.fromCode(fields[INDEX_OF_OPERATION_IN_RECORD]);
        Fruit fruit = Fruit.valueOf(fields[INDEX_OF_FRUIT_IN_RECORD].toUpperCase());
        int quantity = Integer.parseInt(fields[INDEX_OF_QUANTITY_IN_RECORD]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
