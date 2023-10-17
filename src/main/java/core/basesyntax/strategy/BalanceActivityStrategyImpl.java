package core.basesyntax.strategy;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivityStrategyImpl implements TypeActivityStrategy {
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public void setAmountOfFruit(FruitTransaction fruitTransaction) {
        fruitTransactionDao.addToStorage(fruitTransaction);
    }
}
