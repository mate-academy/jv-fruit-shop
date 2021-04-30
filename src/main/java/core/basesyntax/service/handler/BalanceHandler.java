package core.basesyntax.service.handler;

public class BalanceHandler implements OperationHandler {
    @Override
    public int updateQuantity(int current, int input) {
        return current + input;
    }
}
