package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnStrategyHandlerImpl implements StrategyHandler {
    private final FruitDao fruitDao;

    public ReturnStrategyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer diffQuantity = fruitTransaction.getQuantity();
        fruitDao.getFruitMap().merge(fruitName, diffQuantity, Integer::sum);
    }
}
