package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getByCode(String code) {
            for (Operation operation : values()) {
                if (operation.getOperation().equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException("Can`t use this code " + code);
        }

        public String getOperation() {
            return operation;
        }

    }
}
