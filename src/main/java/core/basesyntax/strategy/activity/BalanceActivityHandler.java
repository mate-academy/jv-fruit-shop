package core.basesyntax.strategy.activity;

public class BalanceActivityHandler implements ActivityHandler {
    @Override
    public int get(int quantity) {
        return quantity;
    }
}
