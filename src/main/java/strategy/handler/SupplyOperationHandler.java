package strategy.handler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer getAmount(int quantity) {
        return quantity;
    }
}
