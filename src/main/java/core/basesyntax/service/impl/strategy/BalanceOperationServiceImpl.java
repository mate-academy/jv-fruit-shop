package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class BalanceOperationServiceImpl implements OperationService<FruitTransaction> {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public Integer processOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() >= 0) {
            return fruitDao.setFruitBalance(fruitTransaction.getFruitName(),
                    fruitTransaction.getQuantity());
        } else {
            throw new InvalidOperationException("You cannot put a negative amount of "
                    + "fruit on the balance");
        }
    }
}
