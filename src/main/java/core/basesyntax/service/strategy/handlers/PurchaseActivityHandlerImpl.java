package core.basesyntax.service.strategy.handlers;

public class PurchaseActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value * (-1);
    }
}
