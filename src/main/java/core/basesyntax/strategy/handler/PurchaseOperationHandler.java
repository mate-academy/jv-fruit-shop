package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        checkValidQuantity(fruitTransaction);
        fruitDao.update(fruitTransaction.getFruit(),
                fruitDao.get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }

    private void checkValidQuantity(FruitTransaction fruitTransaction) {
        int fruitQuantityInStorage = fruitDao.get(fruitTransaction.getFruit());
        int newQuantityInStorage = fruitQuantityInStorage - fruitTransaction.getQuantity();
        if (newQuantityInStorage < 0) {
            throw new RuntimeException("Negative quantity");
        }
    }
}
