package model;

public class TransactionDto {
    private String activity;
    private String fruitName;
    private int quantity;

    public TransactionDto(String activity, String fruitName, int quantity) {
        setActivity(activity);
        setFruitName(fruitName);
        setQuantity(quantity);
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        if (activity == null || activity.trim().isEmpty()) {
            throw new IllegalArgumentException("Activity cannot be null or empty");
        }
        this.activity = activity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        if (fruitName == null || fruitName.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be null or empty");
        }
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive value");
        }
        this.quantity = quantity;
    }
}

