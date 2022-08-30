package core.basesyntax.model;

public class Transaction {
    private Fruit fruit;
    private Integer amount;
    private String activities;

    public Transaction(String activities, Fruit fruit, Integer amount) {
        this.fruit = fruit;
        this.amount = amount;
        this.activities = activities;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }
}
