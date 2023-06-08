package core.basesyntax.service.strategy;

public class SupplyOperationHandler implements OperationHandler {

    public SupplyOperationHandler() {
    }

    @Override
    public Integer applyOperation(Integer amount) {
        return amount;
    }
}
