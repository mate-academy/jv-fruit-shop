package strategy;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public int handleOperation(String fruit, int quantity) {
        return quantity;
    }
}
