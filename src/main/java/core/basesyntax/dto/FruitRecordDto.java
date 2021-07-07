package core.basesyntax.dto;

import core.basesyntax.model.Fruit;

public class FruitRecordDto {
    private Fruit fruit;
    private long amount;
    private Type type;

    public FruitRecordDto(Type type, String fruitName, long amount) {
        this.fruit = new Fruit(fruitName, amount);
        this.amount = amount;
        this.type = type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        p, s, b, r
    }
}

