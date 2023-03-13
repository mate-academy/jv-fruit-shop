package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.UnaryOperation;

public class ApplyBalance implements UnaryOperation {
    private FruitNegotiation myFruit;

    public ApplyBalance(FruitNegotiation fruit) {
        this.myFruit = fruit;
    }

    @Override
    public void apply() {
        Storage.storage.put(myFruit.getFruit(),myFruit.getQuantity());
    }
}
