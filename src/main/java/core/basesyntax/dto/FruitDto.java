package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TypeOfOperation;

public class FruitDto {
    private final TypeOfOperation type;
    private final Fruit fruit;
    private final int amountOfFruit;

    public FruitDto(TypeOfOperation type, Fruit fruit, int amountOfFruit) {
        this.type = type;
        this.fruit = fruit;
        this.amountOfFruit = amountOfFruit;
    }

    public TypeOfOperation getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmountOfFruit() {
        return amountOfFruit;
    }

}
