package core.basesyntax;

import core.basesyntax.model.Fruit;

public class FruitShop {
    private Fruit fruit;
    private Operation operation;
    int quantity;

   /* public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
    }*/

    public FruitShop(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
