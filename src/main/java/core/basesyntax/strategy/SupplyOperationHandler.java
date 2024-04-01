package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitDao.containsFruit(fruitTransaction.getFruit())) {
            fruitDao.update(fruitTransaction.getFruit(),
                    fruitDao.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
        } else {
            fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
