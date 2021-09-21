package core.basesyntax.model;

public class Fruit {
    private String sort;
    private int amount;

    public Fruit(String sort, int amount) {
        this.sort = sort;
        this.amount = amount;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String type) {
        this.sort = sort;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
