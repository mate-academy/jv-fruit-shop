package core.basesyntax.model;

public class Transaction {
    private Operation operationType;
    private String name;
    private Integer quantity;

    public Transaction(Operation operationType, String name, Integer quantity) {
        this.operationType = operationType;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
