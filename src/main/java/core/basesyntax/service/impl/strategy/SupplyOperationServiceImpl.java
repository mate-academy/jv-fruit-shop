package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class SupplyOperationServiceImpl implements OperationService<FruitTransaction> {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public Integer processOperation(FruitTransaction fruitTransaction) {
        return fruitDao.addFruits(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
    }
}
