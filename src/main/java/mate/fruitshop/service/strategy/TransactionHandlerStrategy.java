package mate.fruitshop.service.strategy;

import java.util.Map;
import mate.fruitshop.model.FruitTransaction;

public class TransactionHandlerStrategy {
    public static final Map<FruitTransaction.Operation, FruitTransactionHandler>
            TRANSACTIONS_MAP = Map.of(
            FruitTransaction.Operation.BALANCE, new FruitBalanceHandler(),
            FruitTransaction.Operation.SUPPLY, new FruitSupplyHandler(),
            FruitTransaction.Operation.PURCHASE, new FruitPurchaseHandler(),
            FruitTransaction.Operation.RETURN, new FruitReturnHandler());
}
