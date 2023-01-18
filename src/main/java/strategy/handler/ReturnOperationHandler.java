package strategy.handler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getAmount(int quantity) {
        return quantity;
    }
}
