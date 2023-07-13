package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int amount = fruitDao.getQuantity(fruit);
        int amountPurchase = transaction.getQuantity();
        if (amountPurchase <= amount) {
            fruitDao.addFruit(fruit, fruitDao.getQuantity(fruit) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Can't purchase that amount of " + fruit);
        }
    }
}
