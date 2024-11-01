package core.basesyntax.model;

public class ShopTransaction {
    private final OperationType type;
    private final String fruitName;
    private final int weight;

    public ShopTransaction(OperationType type, String name, int weight) {
        this.type = type;
        this.fruitName = name;
        this.weight = weight;
    }

    public OperationType getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ShopTransaction{"
                + "type=" + type
                + ", name='" + fruitName + '\''
                + ", weight="
                + weight
                + '}';
    }
}
