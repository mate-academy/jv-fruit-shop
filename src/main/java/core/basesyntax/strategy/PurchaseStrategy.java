package core.basesyntax.strategy;

public class PurchaseStrategy extends OperationStrategy {
    @Override
    public int process(int baseQty, int operationQty) {
        return baseQty - operationQty;
    }
}
