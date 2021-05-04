package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Transaction;

public class OperationsStrategyImpl implements OperationsStrategy {
    @Override
    public Integer getStrategy(Transaction transaction) {
        int output = 0;
        if ("s".equals(transaction.getOperationType())
                || "r".equals(transaction.getOperationType())) {
            output = transaction.getCount();
        } else {
            output = transaction.getCount() * -1;
        }
        return output;
    }
}
