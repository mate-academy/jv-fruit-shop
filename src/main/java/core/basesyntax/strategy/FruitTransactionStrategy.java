package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionStrategy;
import core.basesyntax.strategy.impl.PurchaseTransactionStrategy;
import core.basesyntax.strategy.impl.ReturnTransactionStrategy;
import core.basesyntax.strategy.impl.SupplyTransactionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionStrategy {
    private final Map<FruitTransaction.Operation,
            TransactionProcessor> processors = new HashMap<>();

    public FruitTransactionStrategy() {
        processors.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionStrategy());
        processors.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionStrategy());
        processors.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionStrategy());
        processors.put(FruitTransaction.Operation.RETURN, new ReturnTransactionStrategy());
    }

    public void executeTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            TransactionProcessor processor = processors.get(operation);
            if (processor != null) {
                processor.process(transaction);
            }
        }
    }
}
