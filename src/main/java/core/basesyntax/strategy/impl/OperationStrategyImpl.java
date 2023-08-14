package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private FruitDao fruitDao;
    private FruitTransactionDao fruitTransactionDao;

    public OperationStrategyImpl(FruitDao fruitDao, FruitTransactionDao fruitTransactionDao) {
        this.fruitDao = fruitDao;
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public OperationService getOperation(FruitTransaction.Operation type) {
        switch (type) {
            case BALANCE:
                return new BalanceOperationService(fruitDao);
            case PURCHASE:
                return new PurchaseOperationService(fruitDao);
            case SUPPLY:
                return new SupplyOperationService(fruitDao);
            default:
                return new ReturnOperationService(fruitDao, fruitTransactionDao);
        }
    }
}
