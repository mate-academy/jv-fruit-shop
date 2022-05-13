package core.basesyntax.strategy.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer handle(Integer amount) {
        return amount;
    }
}
