package core.basesyntax.strategy.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getShopOperation(Integer amount) {
        return amount;
    }
}

