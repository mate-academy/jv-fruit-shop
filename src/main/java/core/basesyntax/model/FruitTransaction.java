package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Type type;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String typeOperation;

        Type(String typeOperation) {
            this.typeOperation = typeOperation;
        }

        public String getTypeOperation() {
            return typeOperation;
        }
    }
}
