package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationService;
import java.math.BigDecimal;

public class BalanceOperationService implements OperationService {
    private FruitDao fruitDao;

    public BalanceOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        fruitDao.add(new Fruit(fruitName, quantity));
    }
}
