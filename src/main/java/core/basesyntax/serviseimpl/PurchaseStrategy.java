package core.basesyntax.serviseimpl;

import core.basesyntax.servise.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public int apply(int balanece, int quantity) {
        int result = balanece - quantity;
        if (result < 0) {
            throw new RuntimeException("Negative balance: " + result);
        }
        return result;
    }
}
