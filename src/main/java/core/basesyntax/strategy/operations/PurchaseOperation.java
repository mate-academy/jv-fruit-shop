package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements DailyOperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction dailyTransaction) {
        int amountFruits;
        amountFruits = dailyTransaction.getQuantity();
        fruitDao.get(dailyTransaction.getFruitName()).setQuantity(
                fruitDao.get(dailyTransaction.getFruitName()).getQuantity() - amountFruits);
    }
}
