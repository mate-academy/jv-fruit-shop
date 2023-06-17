package fruit.shop.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int value;

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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String stringOption;

        Operation(String stringOption) {
            this.stringOption = stringOption;
        }

        public static Operation getOptionRepresentation(String option) {
            for (Operation operation : Operation.values()) {
                if (operation.stringOption.equals(option)) {
                    return operation;
                }
            }
            throw new RuntimeException("There is no such option!");
        }
    }
}
