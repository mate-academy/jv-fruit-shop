package core.basesyntax.service.strategy;

public class SupplyActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
