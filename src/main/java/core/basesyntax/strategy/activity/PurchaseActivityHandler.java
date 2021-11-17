package core.basesyntax.strategy.activity;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public int get(int quantity) {
        return -quantity;
    }
}
