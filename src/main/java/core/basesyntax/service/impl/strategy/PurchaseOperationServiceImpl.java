package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class PurchaseOperationServiceImpl implements OperationService {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        int currentBalance = fruitDao.getFruitBalance(fruitTransaction.getFruitName());
        int inputQuantity = fruitTransaction.getQuantity();

        if (currentBalance - inputQuantity >= 0) {
            fruitDao.setFruitBalance(fruitTransaction.getFruitName(),
                    currentBalance - inputQuantity);
        } else {
            throw new InvalidOperationException(String
                    .format("You cannot get more fruits than are available. Available quantity"
                                    + " of %s: %d; You are attempting to purchase: %d",
                            fruitTransaction.getFruitName(), currentBalance, inputQuantity));
        }
    }
}
