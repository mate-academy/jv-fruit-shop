package dto;

public class ShopOperation {
    private final String operation;
    private final String fruitName;
    private final int quantity;

    public ShopOperation(String operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShopOperation{"
                + "operation='" + operation + '\''
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity + '}';
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

}
