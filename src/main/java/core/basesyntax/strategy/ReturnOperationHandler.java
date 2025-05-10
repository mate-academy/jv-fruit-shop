package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.InvalidQuantityException;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new InvalidQuantityException("Return can't be less 0");
        }
        fruitDao.plus(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
