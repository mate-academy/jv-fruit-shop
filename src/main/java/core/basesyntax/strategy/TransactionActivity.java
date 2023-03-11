package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.impl.BalanceActivity;
import core.basesyntax.strategy.impl.PurchaseActivity;
import core.basesyntax.strategy.impl.ReturnActivity;
import core.basesyntax.strategy.impl.SupplyActivity;

public class TransactionActivity {
    public StoreActivities getActivity(StorageTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                return new BalanceActivity();
            case RETURN:
                return new ReturnActivity();
            case PURCHASE:
                return new PurchaseActivity();
            default:
                return new SupplyActivity();
        }
    }
}
