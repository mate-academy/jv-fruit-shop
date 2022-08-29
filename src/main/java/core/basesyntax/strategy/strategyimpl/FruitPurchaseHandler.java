package core.basesyntax.strategy.strategyimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitData;
import core.basesyntax.model.FruitTransaction;

public class FruitPurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public FruitPurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processedTransaction(FruitTransaction fruitTransaction) {
        int incomeAmount = fruitTransaction.getQuantity();
        int fruitsTotalBalance = fruitDao.get(fruitTransaction.getFruitName()).getQuantity();
        if (fruitsTotalBalance - incomeAmount < 0) {
            throw new RuntimeException("Not enough fruits in shop");
        }

        fruitDao.remove(new FruitData(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity()));
    }
}
