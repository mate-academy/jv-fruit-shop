package core.basesyntax.model;

public class FruitTransaction{
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
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
    // getters, setters, ...

    public enum Operation {
        b("BALANCE"),
        s("SUPPLY"),
        p("PURCHASE"),
        r("RETURN");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}