package model;

public class ReportFruit {
    private final String fruit;
    private int amount;

    public ReportFruit(String fruit, int amount) {
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
