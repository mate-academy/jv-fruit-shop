package core.basesyntax.operation;

import core.basesyntax.db.FruitDao;
import core.basesyntax.exceptions.NoSuchFruitInStorageException;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private static final int ZERO_VALUE = 0;
    private final FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        InputValidator.unexpectedNullOrEmptyFields(fruitTransaction);
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitDao.getFruitQuantity(fruitName);
        int fruitTransitionQuantity = fruitTransaction.getQuantity();
        int purchaseResult = fruitQuantity - fruitTransitionQuantity;
        checkPurchaseAvailability(purchaseResult);
        fruitDao.saveOrUpdate(fruitName, purchaseResult);
    }

    private void checkPurchaseAvailability(Integer purchaseResult) {
        if (purchaseResult < ZERO_VALUE) {
            throw new NoSuchFruitInStorageException("Not enough fruits in storage!");
        }
    }
}
