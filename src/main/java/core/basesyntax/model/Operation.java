package core.basesyntax.model;

public class Operation {
    private final String type;
    private final String fruit;
    private final int amount;

    public Operation(String type, String fruit, int amount) {
        this.type = type;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public enum Type {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private String type;

        Type(String s) {
            this.type = s;
        }

        public String getType() {
            return type;
        }
    }
}
