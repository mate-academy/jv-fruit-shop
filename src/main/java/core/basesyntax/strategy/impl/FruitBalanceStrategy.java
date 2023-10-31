package core.basesyntax.strategy.impl;

import core.basesyntax.dao.BalanceDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.BalanceDaoImpl;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateStrategy;

public class FruitBalanceStrategy implements StorageUpdateStrategy {
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final BalanceDao balanceDao = new BalanceDaoImpl();

    @Override
    public void updateStorage(String fruitName, int amount) {
        fruitDao.addFirst(fruitName, amount);
        balanceDao.add(fruitName, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return operationCode.equals(Operation.BALANCE.getCode());
    }
}
