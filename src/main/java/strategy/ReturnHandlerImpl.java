package strategy;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public int getAmount(int quantity) {
        return quantity;
    }
}
