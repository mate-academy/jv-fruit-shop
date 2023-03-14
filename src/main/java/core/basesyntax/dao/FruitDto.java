package core.basesyntax.dao;

public final class FruitDto {
    private final String fruit;
    private final int amount;

    public FruitDto(String fruit, int amount) {
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
