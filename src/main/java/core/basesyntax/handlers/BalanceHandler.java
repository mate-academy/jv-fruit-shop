package core.basesyntax.handlers;

public class BalanceHandler implements Activity {
    @Override
    public int calculateCount(int currentCount, int count) {
        return currentCount + count;
    }
}
