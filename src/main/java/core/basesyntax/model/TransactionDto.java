package core.basesyntax.model;

public class TransactionDto {
    private final String type;
    private final Fruit fruit;
    private final int amount;

    public TransactionDto(String type, Fruit fruit, int amount) {
        this.type = type;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
