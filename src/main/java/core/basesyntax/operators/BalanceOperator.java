package core.basesyntax.operators;

import core.basesyntax.db.Storage;

public class BalanceOperator implements Operator {
    @Override
    public void doReportOperation(String product, int amount) {
        Storage.storage.put(product, amount);
    }
}
