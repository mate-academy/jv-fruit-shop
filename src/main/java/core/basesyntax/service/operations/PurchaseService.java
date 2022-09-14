package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseService implements Operations{
    /**
     * Take some amount of some fruits from storage
     */
    public void purchase (FruitTransaction fruitTransaction){
        Storage.fruits.get()
    }
}
