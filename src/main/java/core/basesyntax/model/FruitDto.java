package core.basesyntax.model;

public class FruitDto {
    private String name;
    private int amount;

    public FruitDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

}
