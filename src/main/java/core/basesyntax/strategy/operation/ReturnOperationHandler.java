package core.basesyntax.strategy.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getAmountToAdd(Integer amount) {
        return amount;
    }
}

