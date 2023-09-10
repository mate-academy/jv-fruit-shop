package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void updateFruitsInStock(List<FruitTransaction> fruitsList) {
        fruitsList.forEach(ft -> {
            OperationHandler handler = operationStrategy.getOperationHandler(ft.getOperation());
            int oldFruitAmount = fruitDao.get(ft.getFruit());
            int fruitAmount = handler.operate(oldFruitAmount, ft.getAmount());
            fruitDao.add(ft.getFruit(), fruitAmount);
        });
    }
}
