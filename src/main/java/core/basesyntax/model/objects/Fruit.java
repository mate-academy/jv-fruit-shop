package core.basesyntax.model.objects;

import core.basesyntax.model.objects.Plant;

public class Fruit extends Plant {

    public Fruit() {
    }

    public Fruit(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }
}
