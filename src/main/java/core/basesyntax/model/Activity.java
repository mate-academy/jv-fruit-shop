package core.basesyntax.model;

public class Activity {
    private Fruit fruit;
    private Type type;

    public Activity(Type type, String fruitName, long balance) {
        this.fruit = new Fruit(fruitName, balance);
        this.type = type;
    }

    public enum Type {
        p, s, b, r
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Type getType() {
        return type;
    }
}

