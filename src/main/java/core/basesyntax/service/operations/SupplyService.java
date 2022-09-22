package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyService implements Operations{
    /**
     *  Add some amount of some fruits to storage
     */
    FruitDao fruitDao;
    @Override
   public void realization (FruitTransaction fruitTransaction){
        int beginAmount = fruitDao.getFruitAmount(fruitTransaction);
        int newAmount;
        newAmount = beginAmount + fruitTransaction.getQuantity();
        fruitDao.changeAmount(fruitTransaction,newAmount);
    }
}
