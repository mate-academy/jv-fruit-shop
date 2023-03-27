package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public Operation getOperationFromValue(String value) {
        Operation[] operations = Operation.values();
        for (int i = 0; i < operations.length;) {
            if (value.equals(operations[i].getValue())) {
                return operations[i];
            }
            i++;
        }
        return null;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
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

        private final String value;

        Operation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
