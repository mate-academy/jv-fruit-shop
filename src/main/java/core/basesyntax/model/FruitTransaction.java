package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

        public static Operation getType(String operation) {
            switch (operation) {
                case "b" :
                    return FruitTransaction.Operation.BALANCE;
                case "s" :
                    return FruitTransaction.Operation.SUPPLY;
                case "p" :
                    return FruitTransaction.Operation.PURCHASE;
                case "r" :
                    return FruitTransaction.Operation.RETURN;
                default:
                    throw new RuntimeException("can't find according type of operation");
            }
        }
    }
}
