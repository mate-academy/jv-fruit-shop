package core.basesyntax.model;

public class FruitTransactions {
    private char type;
    private String name;
    private int quantity;

    public FruitTransactions(char type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public char getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
