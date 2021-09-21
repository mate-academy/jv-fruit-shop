package core.basesyntax.model;

public class FruitOperationDto {
    private TypeOperation type;
    private Fruit fruit;
    private int quantity;

    public FruitOperationDto(TypeOperation type, Fruit fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypeOperation getType() {
        return type;
    }

    public void setType(TypeOperation type) {
        this.type = type;
    }

}
