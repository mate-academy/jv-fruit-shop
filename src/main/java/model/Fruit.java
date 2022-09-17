package model;

public class Fruit {
    private Operation typeOperation;
    private String name;
    private int quantity;

    public Fruit(Operation typeOperation, String name, int quantity) {
        this.typeOperation = typeOperation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getTypeOperation() {
        return typeOperation;
    }

    @Override
    public String toString() {
        return "Fruit {" + "name ='" + name + '\''
                + ", quantity = " + quantity
                + ", Operation = " + typeOperation + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
