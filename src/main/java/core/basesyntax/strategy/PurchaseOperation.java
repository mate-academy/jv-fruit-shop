package core.basesyntax.strategy;

public class PurchaseOperation implements Operation {
    @Override
    public int process(int quantity) {
        return -quantity;
    }
}
