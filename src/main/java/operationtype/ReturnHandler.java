package operationtype;

public class ReturnHandler implements OperationHandler {
    @Override
    public int apply(int balance, int change) {
        return balance + change;
    }
}
