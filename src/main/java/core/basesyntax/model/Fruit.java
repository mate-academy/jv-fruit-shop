package core.basesyntax.model;

public class Fruit {
    private FruitType type;

    public Fruit(FruitType type) {
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }

    public void setType(FruitType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static Fruit of(String fruitName) {
        switch (fruitName) {
            case "banana" :
                return new Fruit(FruitType.BANANA);
            case "apple" :
                return new Fruit(FruitType.APPLE);
            default :
                return null;
        }
    }
}
