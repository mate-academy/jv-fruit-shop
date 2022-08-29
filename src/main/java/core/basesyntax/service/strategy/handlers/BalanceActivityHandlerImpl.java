package core.basesyntax.service.strategy.handlers;

public class BalanceActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
