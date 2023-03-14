package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = Operation.getByCode(operation);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String s) {
            for (Operation o : new Operation[]{BALANCE, SUPPLY, PURCHASE, RETURN}) {
                if (o.getCode().equals(s)) {
                    return o;
                }
            }
            throw new RuntimeException("This type of operation is not supported");
        }

        public String getCode() {
            return code;
        }
    }
}
