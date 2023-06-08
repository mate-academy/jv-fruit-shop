package core.basesyntax.service.strategy;

public class BalanceOperationHandler implements OperationHandler {

    public BalanceOperationHandler() {
    }

    @Override
    public Integer applyOperation(Integer amount) {
        return amount;
    }
}
