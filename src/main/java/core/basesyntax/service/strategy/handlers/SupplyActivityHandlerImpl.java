package core.basesyntax.service.strategy.handlers;

public class SupplyActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
