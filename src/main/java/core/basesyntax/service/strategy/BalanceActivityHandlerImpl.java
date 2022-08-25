package core.basesyntax.service.strategy;

public class BalanceActivityHandlerImpl implements ActivityHandler {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
