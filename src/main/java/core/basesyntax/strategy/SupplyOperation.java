package core.basesyntax.strategy;

public class SupplyOperation implements OperationHandler {
    @Override
    public int warehouse(int balance, int quantity) {
        return balance + quantity;
    }
}
