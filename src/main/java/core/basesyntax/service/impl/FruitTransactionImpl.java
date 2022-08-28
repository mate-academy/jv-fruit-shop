package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.AmountHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;

    public FruitTransactionImpl(Map<String, AmountHandler> amountHandlerMap) {
        transactionStrategy = new TransactionStrategyImpl(amountHandlerMap);
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void fruitTransaction(String fruitName, String strategy, int amount) {
        Fruit fruit = fruitDao.get(fruitName);
        fruit.setAmount(transactionStrategy.get(strategy).changeAmount(fruit, amount));
    }
}
