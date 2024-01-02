package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class PurchaseOperationServiceImpl implements OperationService<FruitTransaction> {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public int processOperation(FruitTransaction fruitTransaction) {

        return fruitDao.subtractFruits(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
    }
}
