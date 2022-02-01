package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHendler;

public class OperationHendlerReturn implements OperationHendler {
    @Override
    public void getOperation(FruitDao fruitDao, FruitTransaction fruitTransaction) {
        fruitDao.summQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
