package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Integer currentQuantity = fruitDao.get(transaction.getFruit());
        int purchaseQuantity = transaction.getQuantity();
        if (purchaseQuantity <= 0 && purchaseQuantity > currentQuantity) {
            throw new IllegalArgumentException("Invalid purchase quantity - " + purchaseQuantity);
        }
        fruitDao.update(transaction.getFruit(), currentQuantity - purchaseQuantity);
    }
}
