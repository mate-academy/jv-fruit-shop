package core.basesyntax.strategy;

import core.basesyntax.service.BalanceQuantityCounter;
import core.basesyntax.service.PurchaseQuantityCounter;
import core.basesyntax.service.QuantityCounter;
import core.basesyntax.service.ReturnQuantityCounter;
import core.basesyntax.service.SupplyQuantityCounter;
import core.basesyntax.transaction.Transaction;
import java.util.Map;

public class QuantityCountersMap {
    private final Map<Transaction.Operation, QuantityCounter> quantityCountersMap =
            Map.of(Transaction.Operation.BALANCE, new BalanceQuantityCounter(),
            Transaction.Operation.SUPPLY, new SupplyQuantityCounter(),
            Transaction.Operation.PURCHASE, new PurchaseQuantityCounter(),
            Transaction.Operation.RETURN, new ReturnQuantityCounter());

    public Map<Transaction.Operation, QuantityCounter> getQuantityCountersMap() {
        return quantityCountersMap;
    }
}
