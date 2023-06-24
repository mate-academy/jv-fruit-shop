package core.basesyntax.service.implementations;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String operation) {
            this.code = operation;
        }

        static Operation getByCode(String code) {
            for (Operation o : Operation.values()) {
                if (code.equals(o.getOperation())) {
                    return o;
                }
            }
            return null;
        }

        public String getOperation() {
            return code;
        }
    }
}
