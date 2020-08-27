package model;

public class Fruit {
    private String name;
    private int quantity;
    private String date;

    public Fruit(String name, int quantity, String date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
