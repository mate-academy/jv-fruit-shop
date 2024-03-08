package core.basesyntax.model;

public class Fruit {
    private String fruitName;
    private int quantity;
    private int sold;

    public Fruit(String fruitName, int quantity, int sold) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.sold = sold;
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

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
