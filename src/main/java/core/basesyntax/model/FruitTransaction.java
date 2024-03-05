package java.core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private Integer quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
