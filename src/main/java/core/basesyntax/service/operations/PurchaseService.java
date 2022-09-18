package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseService implements Operations{
    /**
     * Take some amount of some fruits from storage
     */
    @Override
    public void realization(FruitTransaction fruitTransaction) {
        int beginAmount;
        int newAmount;
        beginAmount = Storage.fruits.get(fruitTransaction.getFruit());
        if ( fruitTransaction.getQuantity() > beginAmount){
            throw new RuntimeException("Impossible transaction. There aren`t needed value of fruits");
        }else {
            newAmount = beginAmount - fruitTransaction.getQuantity();
        }
        Storage.fruits.replace(fruitTransaction.getFruit(),newAmount);
    }
}
