package core.basesyntax.model;

public class FruitRecordDto {
    private String type;
    private Fruit fruit;
    private int quantity;

    public FruitRecordDto(String type, Fruit fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
