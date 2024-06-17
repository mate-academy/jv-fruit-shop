package model;

public class FruitRecord {
    private Type type;
    private String fruit;
    private int quantity;

    public FruitRecord(Type type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    @Override
    public String toString() {
        return "FruitRecord{"
                + "type='" + type + '\''
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String type;

        Type(String operation) {
            this.type = operation;
        }

        public String getType() {
            return type;
        }

        public static Type valueOfType(String type) {
            for (Type element : values()) {
                if (element.getType().equalsIgnoreCase(type)) {
                    return element;
                }
            }
            throw new RuntimeException("Invalid code value of type: " + type);
        }
    }
}
