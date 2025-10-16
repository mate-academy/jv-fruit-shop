package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException(
                    "transaction must not be null");
        }
        if (transaction.getFruit() == null
                || transaction.getFruit().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "transaction.fruit must not be null or blank");
        }
        fruitDao.set(transaction.getFruit(), transaction.getQuantity());
    }
}
