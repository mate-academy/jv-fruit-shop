package core.basesyntax.strategy.impl;

import core.basesyntax.dao.BalanceDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.BalanceDaoImpl;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.exception.GoodsMoreBalanceAmountException;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateStrategy;

public class FruitReturnStrategy implements StorageUpdateStrategy {
    private static final String RETURNING_FAILURE_MESSAGE = "It is impossible "
            + "to return more {%s} than supplied!";
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final BalanceDao balanceDao = new BalanceDaoImpl();

    @Override
    public void updateStorage(String fruitName, int amount) {
        int amountDifference = balanceDao.get(fruitName) - amount;
        if (amountDifference < 0) {
            throw new GoodsMoreBalanceAmountException(String
                    .format(RETURNING_FAILURE_MESSAGE, fruitName));
        }
        fruitDao.add(fruitName, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return operationCode.equals(Operation.RETURN.getCode());
    }
}
