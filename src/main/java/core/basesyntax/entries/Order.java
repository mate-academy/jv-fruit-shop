package core.basesyntax.entries;

import java.util.Objects;

public class Order {
    private FruitPack fruitPack;
    private String typeOfOperation;

    public Order(FruitPack fruitPack, String typeOfOperation) {
        this.fruitPack = fruitPack;
        this.typeOfOperation = typeOfOperation;
    }

    public FruitPack getFruitPack() {
        return fruitPack;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(fruitPack, order.fruitPack)
                && Objects.equals(typeOfOperation, order.typeOfOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitPack, typeOfOperation);
    }
}
