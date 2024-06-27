package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Integer currentQuantity = fruitDao.get(transaction.getFruit());
        int purchaseQuantity = transaction.getQuantity();
        if (purchaseQuantity < 0) {
            throw new IllegalArgumentException("Invalid supply quantity - " + purchaseQuantity);
        }
        fruitDao.getStorage().put(transaction.getFruit(), currentQuantity + purchaseQuantity);
    }
}
