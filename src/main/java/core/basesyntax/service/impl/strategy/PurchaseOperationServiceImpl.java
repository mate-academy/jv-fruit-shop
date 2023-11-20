package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class PurchaseOperationServiceImpl implements OperationService {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public int processOperation(FruitTransaction fruitTransaction) {

        return fruitDao.getFruitsFromBalance(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
    }
}
