package model;

public class OutFileStructure {
    private String fruit;
    private String quantity;

    public OutFileStructure() {
    }

    public OutFileStructure(String fruit, String quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
