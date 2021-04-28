package core.basesyntax.fruit.dto;

public class FruitDto {
    private final String fruitType;
    private final int amount;

    public FruitDto(String fruitType, int amount) {
        this.fruitType = fruitType;
        this.amount = amount;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getAmount() {
        return amount;
    }
}
