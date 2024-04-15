package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.InvalidQuantityException;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new InvalidQuantityException("Supply can't be less 0");
        }
        if (fruitDao.containsFruit(fruitTransaction.getFruit())) {
            fruitDao.plus(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
