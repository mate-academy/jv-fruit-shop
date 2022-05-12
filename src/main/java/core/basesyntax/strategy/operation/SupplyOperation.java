package core.basesyntax.strategy.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer doOperation(Integer amount) {
        return amount;
    }
}
