package core.basesyntax;

import core.basesyntax.activity.ActivityTypes;

public class Record {
    private String activity;
    private String fruit;
    private int amount;


    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getActivity() {
        return activity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
