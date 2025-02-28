package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
