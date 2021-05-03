package core.basesyntax.servise;

public class FruitRecordDto {
    private Operation type;
    private String fruit;
    private int amountOfFruit;

    public FruitRecordDto(Operation type, String fruit, int amountOfFruit) {
        this.type = type;
        this.fruit = fruit;
        this.amountOfFruit = amountOfFruit;
    }

    public Operation getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmountOfFruit() {
        return amountOfFruit;
    }
}
