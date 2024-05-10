package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyStrategyHandlerImpl implements StrategyHandler {
    private final FruitDao fruitDao;

    public SupplyStrategyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int handle(FruitTransaction fruitTransaction) {
        Integer oldQuantity = fruitDao.getFruitMap().get(fruitTransaction.getFruitName());
        Integer newQuantity = fruitTransaction.getQuantity();
        return oldQuantity + newQuantity;
    }
}
