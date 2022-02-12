package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class StorageTransaction {
    private final Map<String, OperationTransaction> storageTransactions = new HashMap<>();

    public Map<String, OperationTransaction> getTransactions() {
        storageTransactions.put("b", new BalanceTransaction());
        storageTransactions.put("s", new SupplyTransaction());
        storageTransactions.put("p", new PurchaseTransaction());
        storageTransactions.put("r", new SupplyTransaction());
        return storageTransactions;
    }
}
