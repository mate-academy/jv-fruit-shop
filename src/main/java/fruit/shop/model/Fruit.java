package fruit.shop.model;

public enum Fruit {
    BANANA, APPLE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
