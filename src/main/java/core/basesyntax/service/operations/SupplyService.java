package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyService implements Operations{
    /**
     *  Add some amount of some fruits to storage
     */
    @Override
   public void realization (FruitTransaction fruitTransaction){
        int beginAmount = Storage.fruits.get(fruitTransaction.getFruit());
        int newAmount;
        newAmount = beginAmount + fruitTransaction.getQuantity();
        Storage.fruits.replace(fruitTransaction.getFruit(),newAmount);
    }
}
