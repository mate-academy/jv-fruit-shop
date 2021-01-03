package store.model;

public class Fruits {
    private String name;
    private int cost;

    public Fruits(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Fruits [" + name + ", "
                + cost + "]";
    }
}
