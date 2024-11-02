package core.basesyntax.model;

public class ShopOperation {
    private final OperationType type;
    private final String fruit;
    private final int quantity;

    public ShopOperation(OperationType type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ShopOperation{"
                + "type=" + type
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity + '}';
    }
}
