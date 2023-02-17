package core.basesyntax.model;

import java.util.Objects;

public class FruitOperation {
    private TypeActivity typeActivity;
    private Fruit fruit;
    private int quantity;

    public FruitOperation(TypeActivity typeActivity, Fruit fruit, int quantity) {
        this.typeActivity = typeActivity;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public TypeActivity getTypeActivity() {
        return typeActivity;
    }

    public void setTypeActivity(TypeActivity typeActivity) {
        this.typeActivity = typeActivity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitOperation that = (FruitOperation) o;
        return quantity == that.quantity
                && typeActivity == that.typeActivity
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeActivity, fruit, quantity);
    }
}

