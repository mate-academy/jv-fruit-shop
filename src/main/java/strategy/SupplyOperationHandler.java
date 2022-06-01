package strategy;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int initialQuantity, int amount) {
        return initialQuantity + amount;
    }
}
