package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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
        BALANCE("b"), //залишки плодів
        SUPPLY("s"), //поставка нових фруктів
        PURCHASE("p"), //покупка клієнтів
        RETURN("r"); //повернення клієнтів

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String code) {
            for (Operation value : values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(
                    code + " operation doesn't exist.");
        }
    }
}
