package core.basesyntax.strategy.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer doOperation(Integer amount) {
        return amount;
    }
}
