package core.basesyntax.operation;

import core.basesyntax.db.FruitDao;
import core.basesyntax.exceptions.NoSuchFruitInStorageException;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private static final int ZERO_VALUE = 0;
    private FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransition) {
        String fruitName = fruitTransition.getFruitName();
        Integer fruitQuantity = fruitDao.getFruitQuantity(fruitName);
        int fruitTransitionQuantity = fruitTransition.getQuantity();
        Integer purchaseResult = fruitQuantity - fruitTransitionQuantity;
        canBePurchased(purchaseResult);
        fruitDao.addOrUpdateFruitToStorage(fruitName, purchaseResult);
    }

    private void canBePurchased(Integer purchaseResult) {
        if (purchaseResult < ZERO_VALUE) {
            throw new NoSuchFruitInStorageException("Not enough fruits in storage!");
        }
    }
}
