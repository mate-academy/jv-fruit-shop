package core.basesyntax.strategy.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer getAmountToAdd(Integer amount) {
        return amount;
    }
}
