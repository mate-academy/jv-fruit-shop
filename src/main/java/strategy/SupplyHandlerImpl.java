package strategy;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public int getAmount(int quantity) {
        return quantity;
    }
}
