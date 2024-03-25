package mate.fruitshop.service.strategy;

import java.util.HashMap;
import java.util.Map;
import mate.fruitshop.model.FruitTransaction;

public class TransactionHandlerStrategy {
    public static final Map<FruitTransaction.Operation, FruitTransactionHandler>
            TRANSACTIONS_MAP = new HashMap<>();

    static {
        TRANSACTIONS_MAP.put(FruitTransaction.Operation.BALANCE, new FruitBalanceHandler());
        TRANSACTIONS_MAP.put(FruitTransaction.Operation.SUPPLY, new FruitSupplyHandler());
        TRANSACTIONS_MAP.put(FruitTransaction.Operation.PURCHASE, new FruitPurchaseHandler());
        TRANSACTIONS_MAP.put(FruitTransaction.Operation.RETURN, new FruitReturnHandler());
    }
}
