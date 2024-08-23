package core.basesyntax.utils.transaction;

public class FruitTransaction {
    private final int quantity;
    private final String product;
    private final Operation operation;

    public FruitTransaction(int quantity, String product, Operation operation) {
        this.quantity = quantity;
        this.product = product;
        this.operation = operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }

    public Operation getOperation() {
        return operation;
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
