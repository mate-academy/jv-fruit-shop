package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

public class BalanceOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        FruitService fruitService = new FruitServiceImpl(fruitsDao);
        fruitService.createFruit(fruitName, quantity);
    }
}
