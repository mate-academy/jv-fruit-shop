package core.basesyntax.strategy.activity;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public int get(int quantity) {
        return quantity;
    }
}
