package core.basesyntax.model;

public class Fruit {
    private Operation operation;
    private String fruit;
    private int amount;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

        public static Operation getCode(String code) {
            switch (code) {
                case ("b"):
                    return Operation.BALANCE;
                case ("s"):
                    return Operation.SUPPLY;
                case ("p"):
                    return Operation.PURCHASE;
                case ("r"):
                    return Operation.RETURN;
                default:
                    return null;
            }
        }
    }
}
