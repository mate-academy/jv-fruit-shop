package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
