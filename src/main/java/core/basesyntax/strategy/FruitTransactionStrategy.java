package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionStrategy;
import core.basesyntax.strategy.impl.PurchaseTransactionStrategy;
import core.basesyntax.strategy.impl.ReturnTransactionStrategy;
import core.basesyntax.strategy.impl.SupplyTransactionStrategy;
import java.util.List;

public class FruitTransactionStrategy {
    public void executeTransaction(List<FruitTransaction> fruitTransactions) {
        BalanceTransactionStrategy balanceTransactionStrategy
                = new BalanceTransactionStrategy();
        PurchaseTransactionStrategy purchaseTransactionStrategy
                = new PurchaseTransactionStrategy();
        SupplyTransactionStrategy supplyTransactionStrategy
                = new SupplyTransactionStrategy();
        ReturnTransactionStrategy returnTransactionStrategy
                = new ReturnTransactionStrategy();

        for (FruitTransaction transaction : fruitTransactions) {
            String code = transaction.getOperation().getCode();
            if (code.equals(FruitTransaction.Operation.BALANCE.getCode())) {
                balanceTransactionStrategy.process(transaction);
            } else if (code.equals(FruitTransaction.Operation.PURCHASE.getCode())) {
                purchaseTransactionStrategy.process(transaction);
            } else if (code.equals(FruitTransaction.Operation.SUPPLY.getCode())) {
                supplyTransactionStrategy.process(transaction);
            } else if (code.equals(FruitTransaction.Operation.RETURN.getCode())) {
                returnTransactionStrategy.process(transaction);
            }
        }
    }
}
