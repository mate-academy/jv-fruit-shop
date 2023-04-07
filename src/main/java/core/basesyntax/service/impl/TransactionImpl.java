package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyProvider;
import core.basesyntax.service.Transaction;
import java.util.List;

public class TransactionImpl implements Transaction {
    @Override
    public void transaction(List<FruitTransaction> fruitTransactions,
                            StrategyProvider strategyProvider) {
        for (FruitTransaction transaction : fruitTransactions) {
            strategyProvider.getStrategy(transaction.getOperation())
                    .calculate(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
