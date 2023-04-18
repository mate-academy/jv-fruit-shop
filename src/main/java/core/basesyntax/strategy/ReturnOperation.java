package core.basesyntax.strategy;

public class ReturnOperation implements Operation {
    @Override
    public int process(int quantity) {
        return +quantity;
    }
}
