package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class ReturnOperationServiceImpl implements OperationService {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public int processOperation(FruitTransaction fruitTransaction) {
        return fruitDao.addFruitsToBalance(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
    }
}
