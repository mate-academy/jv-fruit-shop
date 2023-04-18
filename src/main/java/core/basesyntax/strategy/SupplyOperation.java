package core.basesyntax.strategy;

public class SupplyOperation implements Operation {
    @Override
    public int process(int quantity) {
        return +quantity;
    }
}
