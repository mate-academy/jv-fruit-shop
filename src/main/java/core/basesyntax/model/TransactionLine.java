package core.basesyntax.model;

public class TransactionLine {
    private final String typeActivity;
    private final String fruitName;
    private final int quantity;

    public TransactionLine(String typeActivity, String fruitName, int quantity) {
        this.typeActivity = typeActivity;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getTypeActivity() {
        return typeActivity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
