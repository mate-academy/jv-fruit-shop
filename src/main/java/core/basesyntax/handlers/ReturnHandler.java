package core.basesyntax.handlers;

public class ReturnHandler implements Activity {
    @Override
    public int calculateCount(int currentCount, int newCount) {
        return currentCount + newCount;
    }
}
