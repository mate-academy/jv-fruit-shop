package model;

public class Activity {
    private Type type;
    private String fruitName;
    private int quantity;

    public Activity(Type type, String fruitName, int quantity) {
        this.type = type;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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


