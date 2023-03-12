package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.UnaryOperation;

public class ApplayBalance implements UnaryOperation {
    private FruitNegotiation myFruit;

    public ApplayBalance(FruitNegotiation fruit) {
        this.myFruit = fruit;
    }

    @Override
    public void applay() {
        Storage.storage.put(myFruit.getFruit(),myFruit.getQuantity());
    }
}
