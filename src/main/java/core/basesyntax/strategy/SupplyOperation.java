package core.basesyntax.strategy;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getStock(int amount) {
        return amount;
    }
}
