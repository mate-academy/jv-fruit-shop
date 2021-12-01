package core.basesyntax.dto;

public class TransactionDto {
    private String operation;
    private String name;
    private int quantity;

    public TransactionDto(String operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation='" + operation + '\''
                + ", name='" + name + '\''
                + ", quantity=" + quantity + '}';
    }
}
