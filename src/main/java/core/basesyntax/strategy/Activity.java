package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivityService;

public abstract class Activity implements ActivityService {
    private Fruit fruit;
    private int quantity;

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
    public String toString() {
        return "Activity{" +
                "fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }
}
