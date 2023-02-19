package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, String quantity) {
        for (Operation o: Operation.values()) {
            if (o.getCode().equals(operation)) {
                this.operation = o;
                break;
            }
        }

        for (Fruit f: Fruit.values()) {
            if (f.getName().equals(fruit)) {
                this.fruit = f;
            }
        }

        this.quantity = Integer.parseInt(quantity);
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
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

        public String getCode() {
            return code;
        }
    }
}
