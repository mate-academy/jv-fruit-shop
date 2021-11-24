package core.basesyntax.model;

public class TransactionDto {
    private String operation;
    private String fruit;
    private int quantity;

    public TransactionDto(String operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
