package core.basesyntax.strategy;

public class ReturnOperation extends OperationStrategy {
    @Override
    public int process(int baseQty, int operationQty) {
        return baseQty + operationQty;
    }
}
