package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        FruitDao fruitDao = new FruitDaoImpl();
        Fruit fruitFromDb = fruitDao.get(fruitTransaction);
        int oldAmount = fruitFromDb.getAmountInShop();
        int newAmount = oldAmount - fruitTransaction.getQuantity();
        fruitDao.update(fruitTransaction, newAmount);
    }
}
