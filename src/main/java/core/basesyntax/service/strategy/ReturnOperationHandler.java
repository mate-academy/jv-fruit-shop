package core.basesyntax.service.strategy;

public class ReturnOperationHandler implements OperationHandler {

    public ReturnOperationHandler() {
    }

    @Override
    public Integer applyOperation(Integer amount) {
        return amount;
    }
}
