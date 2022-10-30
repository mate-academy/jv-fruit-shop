package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class PurchaseService implements OperationService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.get(fruitTransaction.getFruit())
                        .ifPresent(f -> f.setQuantity(f.getQuantity()
                                - fruitTransaction.getQuantity()));
    }
}
