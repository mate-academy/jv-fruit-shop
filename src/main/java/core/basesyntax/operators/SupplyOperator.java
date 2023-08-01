package core.basesyntax.operators;

import core.basesyntax.db.Storage;

public class SupplyOperator implements Operator {
    @Override
    public void doReportOperation(String product, int amount) {
        int productAmount = Storage.storage.get(product) + amount;
        Storage.storage.replace(product, productAmount);
    }
}
