package core.basesyntax.model;

public class FruitTransaction implements Transaction {
    private final Operation operation;
    private final String productName;
    private final int quantity;

    public FruitTransaction(Operation operation, String productName, int quantity) {
        this.operation = operation;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public int getQuantity() {
        return quantity;
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

        public String getCode() {
            return code;
        }
    }
}
