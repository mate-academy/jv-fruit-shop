package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        Fruit fruitFromDb = fruitDao.get(fruitTransaction);
        fruitDao.update(fruitTransaction,
                fruitFromDb.getAmountInShop() - fruitTransaction.getQuantity());
    }
}
