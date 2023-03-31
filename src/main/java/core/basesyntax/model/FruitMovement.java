package core.basesyntax.model;

public final class FruitMovement {
    private final Fruit fruit;
    private final MovementType type;
    private final int amount;

    public FruitMovement(Fruit fruit, MovementType type, int amount) {
        this.fruit = fruit;
        this.type = type;
        this.amount = amount;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public MovementType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
