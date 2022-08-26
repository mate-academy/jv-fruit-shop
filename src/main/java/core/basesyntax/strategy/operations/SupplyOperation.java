package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements DailyOperationHandler {
    private FruitDao fruitDao;

    public SupplyOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction dailyTransaction) {
        int amountFruits = dailyTransaction.getQuantity();
        fruitDao.get(dailyTransaction.getFruitName()).setQuantity(
                fruitDao.get(dailyTransaction.getFruitName()).getQuantity() + amountFruits);
    }
}
