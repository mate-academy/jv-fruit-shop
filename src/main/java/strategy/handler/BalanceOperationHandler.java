package strategy.handler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getAmount(int quantity) {
        return quantity;
    }
}
