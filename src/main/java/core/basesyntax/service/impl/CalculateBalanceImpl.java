package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateBalance;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.CalculateStrategy;
import java.util.List;
import java.util.Map;

public class CalculateBalanceImpl implements CalculateBalance {

    @Override
    public void calculateBalance(List<FruitTransaction> fruitTransactionList,
                    Map<FruitTransaction.Operation, OperationHandler> correspondenceTable) {

        for (int i = 0; i < fruitTransactionList.size(); i++) {
            FruitTransaction fruitTransaction = fruitTransactionList.get(i);
            CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
            calculateStrategy.calculate(fruitTransaction, fruitTransaction.getOperation());
        }
    }
}
