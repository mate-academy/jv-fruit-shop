package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategyService;
import core.basesyntax.service.impl.BalanceTransactionService;
import core.basesyntax.service.impl.PurchaseTransactionService;
import core.basesyntax.service.impl.ReturnTransactionService;
import core.basesyntax.service.impl.SupplyTransactionService;
import java.util.Map;

public class TransactionStrategy {

    private static final Map<FruitTransaction.Operation, TransactionStrategyService>
            transactionServiceMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceTransactionService(),
                FruitTransaction.Operation.PURCHASE, new PurchaseTransactionService(),
                FruitTransaction.Operation.RETURN, new ReturnTransactionService(),
                FruitTransaction.Operation.SUPPLY, new SupplyTransactionService()
            );

    public static TransactionStrategyService getTransactionService(
            FruitTransaction.Operation operation) {
        return transactionServiceMap.get(operation);
    }
}
