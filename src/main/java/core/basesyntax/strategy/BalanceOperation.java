package core.basesyntax.strategy;

public class BalanceOperation extends OperationStrategy {
    @Override
    public int process(int baseQty, int operationQty) {
        return operationQty;
    }
}
