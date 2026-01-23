package core.basesyntax.utility;

public class ValidateData {
    private final String fruit;
    private final int quantity;

    public ValidateData(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
