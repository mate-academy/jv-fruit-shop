package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculateStrategy;
import java.util.List;

public class CalculateBalanceImpl implements CalculateBalance {

    @Override
    public void calculateBalance(List<FruitTransaction> fruitTransactionList) {

        for (int i = 0; i < fruitTransactionList.size(); i++) {
            FruitTransaction fruitTransaction = fruitTransactionList.get(i);
            CalculateStrategy calculateStrategy = new CalculateStrategy();
            calculateStrategy.calculate(fruitTransaction, fruitTransaction.getOperation());
        }
    }
}
