package dto;

import java.util.Objects;
import model.Fruit;

public class Storage {
    public Fruit fruit;
    public Integer quantity;
    public Activities action;

    public Storage() {

    }

    public Storage(Activities action, Fruit fruit, Integer quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.action = action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, quantity, action);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Storage current = (Storage) obj;
            return fruit.equals(current.fruit)
                    && quantity == current.quantity
                    && action.equals(current.action);
        }
        return false;
    }
}
