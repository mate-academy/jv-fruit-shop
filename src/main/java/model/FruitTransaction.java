package model;

public class FruitTransaction {
    private Operation type;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getType() {
        return type;
    }

    public void setOperation(Operation type) {
        this.type = type;
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

        private final String firstLetterOfOperationType;

        Operation(String firstLetterOfOperationType) {
            this.firstLetterOfOperationType = firstLetterOfOperationType;
        }

        public String getFirstLetterOfOperationType() {
            return firstLetterOfOperationType;
        }

        public static Operation getNameOfType(String letterType) {
            for (Operation operationType : Operation.values()) {
                if (operationType.getFirstLetterOfOperationType().equals(letterType)) {
                    return operationType;
                }
            }
            throw new IllegalArgumentException("Unknown operation letterType: " + letterType);
        }
    }

    @Override
    public String toString() {
        return " FruitsTransaction: " + type.getFirstLetterOfOperationType() + " "
                + fruit
                + " "
                + quantity;
    }
}
