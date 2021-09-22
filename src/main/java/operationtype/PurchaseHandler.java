package operationtype;

public class PurchaseHandler implements OperationHandler {

    @Override
    public int apply(int balance, int change) {
        if (balance < change) {
            throw new RuntimeException("Not enough fruit in storage.");
        }
        return balance - change;
    }
}
