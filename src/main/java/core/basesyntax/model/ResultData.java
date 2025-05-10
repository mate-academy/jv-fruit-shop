package core.basesyntax.model;

public class ResultData {
    private String fruitName;
    private int quantity;

    public ResultData(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
