package operationtype;

public class BalanceHandler implements OperationHandler {

    @Override
    public int apply(int balance, int change) {
        return change;
    }
}
