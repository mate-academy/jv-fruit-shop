package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.UnaryOperation;

public class ApplyReturn implements UnaryOperation {
    private FruitNegotiation myFruit;

    public ApplyReturn(FruitNegotiation fruit) {
        this.myFruit = fruit;
    }

    @Override
    public void apply() {
        if (Storage.storage.containsKey(myFruit.getFruit())) {
            Storage.storage.put(myFruit.getFruit(),
                    Storage.storage.get(myFruit.getFruit()).intValue() + myFruit.getQuantity());
        } else {
            Storage.storage.put(myFruit.getFruit(), myFruit.getQuantity());
        }
    }
}
