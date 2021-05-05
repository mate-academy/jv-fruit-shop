package core.basesyntax.servise;

import core.basesyntax.model.Fruit;

public class FruitRecordDto {
    private Operation type;
    private Fruit fruit;
    private int amountOfFruit;

    public FruitRecordDto(Operation type, Fruit fruit, int amountOfFruit) {
        this.type = type;
        this.fruit = fruit;
        this.amountOfFruit = amountOfFruit;
    }

    public Operation getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmountOfFruit() {
        return amountOfFruit;
    }
}
