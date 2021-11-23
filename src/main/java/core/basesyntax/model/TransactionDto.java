package core.basesyntax.model;

public class TransactionDto {
    private String manipulation;
    private String fruitName;
    private int quantity;

    public TransactionDto(String manipulation, String fruitName, int quantity) {
        this.manipulation = manipulation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getManipulation() {
        return manipulation;
    }

    public void setManipulation(String manipulation) {
        this.manipulation = manipulation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
