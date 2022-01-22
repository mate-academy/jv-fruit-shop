package model;

public class TransactionDto {
    private String activity;
    private String fruitName;
    private int quantity;

    public TransactionDto(String activity, String fruitName, int quantity) {
        this.activity = activity;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getActivity() {
        return activity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
