package operationtype;

public class SupplyHandler implements OperationHandler {
    @Override
    public int apply(int balance, int change) {
        return balance + change;
    }
}
