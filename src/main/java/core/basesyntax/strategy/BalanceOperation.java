package core.basesyntax.strategy;

public class BalanceOperation implements Operation {
    @Override
    public int process(int quantity) {
        return quantity;
    }
}
