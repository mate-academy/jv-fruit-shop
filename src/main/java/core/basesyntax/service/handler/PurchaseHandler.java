package core.basesyntax.service.handler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int updateQuantity(int current, int input) {
        int result = current - input;
        if (result < 0) {
            throw new RuntimeException("Invalid quantity");
        }
        return result;
    }
}
