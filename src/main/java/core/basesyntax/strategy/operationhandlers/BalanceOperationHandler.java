package core.basesyntax.strategy.operationhandlers;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public record BalanceOperationHandler(FruitDao fruitDao) implements OperationsHandler {
    private static final String QUALITY_CANT_BE_NEGATIVE = "Quality, can't be negative";

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException(QUALITY_CANT_BE_NEGATIVE);
        }
        fruitDao.putToStorage(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
