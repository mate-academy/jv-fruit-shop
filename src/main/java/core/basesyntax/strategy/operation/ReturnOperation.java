package core.basesyntax.strategy.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer handle(Integer amount) {
        return amount;
    }
}
