package core.basesyntax.strategy;

import core.basesyntax.impl.BalanceTransactionService;
import core.basesyntax.impl.PurchaseTransactionService;
import core.basesyntax.impl.ReturnTransactionService;
import core.basesyntax.impl.SupplyTransactionService;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionStrategyService;
import java.util.Map;

public class TransactionStrategy {
    private static final Map<Operation, TransactionStrategyService>
            currentTransaction = Map.of(
                    Operation.BALANCE, new BalanceTransactionService(),
            Operation.SUPPLY, new SupplyTransactionService(),
            Operation.PURCHASE, new PurchaseTransactionService(),
            Operation.RETURN, new ReturnTransactionService()
    );

    public static TransactionStrategyService getTransactionService(Operation operation) {
        return currentTransaction.get(operation);
    }
}
