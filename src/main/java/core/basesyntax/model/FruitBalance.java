package core.basesyntax.model;

public class FruitBalance {
    private String fruit;
    private int balance;

    public FruitBalance(String fruit, int balance) {
        this.fruit = fruit;
        this.balance = balance;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getFruit() {
        return fruit;
    }

    public int getBalance() {
        return balance;
    }
}
