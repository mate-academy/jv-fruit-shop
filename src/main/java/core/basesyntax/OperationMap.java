package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.BalanceTransactionHandler;
import core.basesyntax.service.transaction.PurchaseTransactionHandler;
import core.basesyntax.service.transaction.ReturnTransactionHandler;
import core.basesyntax.service.transaction.SupplyTransactionHandler;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationMap {
    private Map<FruitTransaction.Operation, TransactionHandler> operationMap;

    public OperationMap() {
        operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
    }

    public Map<FruitTransaction.Operation, TransactionHandler> get() {
        return this.operationMap;
    }
}
