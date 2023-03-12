package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.FruitStoreException;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.UnaryOperation;

public class ApplayPurchase implements UnaryOperation {
    private FruitNegotiation myFruit;

    public ApplayPurchase(FruitNegotiation fruit) {
        this.myFruit = fruit;
    }

    @Override
    public void applay() {
        if (Storage.storage.containsKey(myFruit.getFruit())) {
            if (Storage.storage.get(myFruit.getFruit()).intValue() >= myFruit.getQuantity()) {
                Storage.storage.put(myFruit.getFruit(),
                        Storage.storage.get(myFruit.getFruit()).intValue() - myFruit.getQuantity());
            } else {
                throw new FruitStoreException("Can't selling " + myFruit.getFruit()
                        + " the quantity of which is less on the balance than in query");
            }
        } else {
            throw new FruitStoreException("Can't selling " + myFruit.getFruit()
                    + " fruit that don't getting on balance before");
        }
    }
}
