package core.basesyntax;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
<<<<<<< HEAD
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
=======
>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
    }

    public Operation getOperation() {
        return operation;
    }

<<<<<<< HEAD
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

=======
>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
    public String getFruit() {
        return fruit;
    }

<<<<<<< HEAD
    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

=======
>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
    public int getQuantity() {
        return quantity;
    }

<<<<<<< HEAD
=======
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
<<<<<<< HEAD

        public static Operation fromCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.getCode().equalsIgnoreCase(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + code);
        }
    }
=======
    }

>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
}
