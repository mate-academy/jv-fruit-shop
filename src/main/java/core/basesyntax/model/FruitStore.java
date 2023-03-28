package core.basesyntax.model;

public class FruitStore {
    private String name;

    public FruitStore(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Name can not be null!");
        }
    }

    public String getName() {
        return name;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
