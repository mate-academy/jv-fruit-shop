package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionHandler;
import core.basesyntax.strategy.impl.PurchaseTransactionHandler;
import core.basesyntax.strategy.impl.ReturnTransactionHandler;
import core.basesyntax.strategy.impl.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class TransactionHandlerStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> amountServices;

    {
        amountServices = new HashMap<>();
        amountServices.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        amountServices.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        amountServices.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        amountServices.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
    }

    public TransactionHandler getAmountService(FruitTransaction.Operation operation) {
        return amountServices.get(operation);
    }
}
