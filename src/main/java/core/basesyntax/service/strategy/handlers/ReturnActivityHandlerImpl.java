package core.basesyntax.service.strategy.handlers;

public class ReturnActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
