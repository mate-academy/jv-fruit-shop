package core.basesyntax.operations;

public class BalanceOperation implements Operation {

    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
