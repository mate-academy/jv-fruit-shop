package strategy;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int initialQuantity, int amount) {
        return initialQuantity + amount;
    }
}
