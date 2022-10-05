package core.basesyntax.strategy.strategyImpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationService implements OperationService {
    private final FruitDao fruitDao;

    public BalanceOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        fruitDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
