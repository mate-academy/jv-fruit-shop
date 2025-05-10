package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseStrategyHandlerImpl implements StrategyHandler {
    private final FruitDao fruitDao;

    public PurchaseStrategyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer diffQuantity = fruitTransaction.getQuantity() * (-1);
        fruitDao.getFruitMap().merge(fruitName, diffQuantity, Integer::sum);
    }
}
