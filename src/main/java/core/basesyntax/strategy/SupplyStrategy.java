package core.basesyntax.strategy;

public class SupplyStrategy extends OperationStrategy {
    @Override
    public int process(int baseQty, int operationQty) {
        return baseQty + operationQty;
    }
}
