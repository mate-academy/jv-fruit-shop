package core.basesyntax.strategy;

public class SupplyOperation implements OperationHandler {
    @Override
    public int updateQuantity(int currentQuantity, int quantity) {
        return currentQuantity + quantity;
    }
}
