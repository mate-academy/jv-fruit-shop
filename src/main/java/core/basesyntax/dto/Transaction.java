package core.basesyntax.dto;

public class Transaction {
    private final String operation;
    private final String fruitName;
    private final int quality;

    public Transaction(String operation, String fruit, int quality) {
        this.operation = operation;
        this.fruitName = fruit;
        this.quality = quality;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuality() {
        return quality;
    }
}
