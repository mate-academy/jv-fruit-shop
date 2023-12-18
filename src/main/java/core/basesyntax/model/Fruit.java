package core.basesyntax.model;

public class Fruit {
    private Operation fruitOpCode;
    private String fruitName;
    private int fruitQuantity;

    public Fruit(Operation operationCode, String fruitName, int quantity) {
        this.fruitOpCode = operationCode;
        this.fruitName = fruitName;
        this.fruitQuantity = quantity;
    }

    public Operation getFruitOpCode() {
        return fruitOpCode;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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
