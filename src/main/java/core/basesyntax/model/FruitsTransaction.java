package core.basesyntax.model;

public class FruitsTransaction {
    private final Operation operation;
    private final String name;
    private final int quantity;

    public FruitsTransaction(String operationCode, String name, int quantity) {
        this.operation = Operation.getByCode(operationCode);
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
