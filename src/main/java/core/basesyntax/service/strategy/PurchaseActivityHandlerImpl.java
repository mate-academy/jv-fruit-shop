package core.basesyntax.service.strategy;

public class PurchaseActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value * (-1);
    }
}
