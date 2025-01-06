package transaction;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, int quantity, String fruit) {
        this.operation = operation;
        this.quantity = quantity;
        this.fruit = fruit;
    }

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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode () {
            return code;
        }
        public static Operation checkCode (String code) {
            for (Operation operation : values()) {
               if (operation.code.equals(code)) {
                   return operation;
               }
            }
            throw new IllegalArgumentException("Operation " + code + " does not exist");
        }
    }
}
