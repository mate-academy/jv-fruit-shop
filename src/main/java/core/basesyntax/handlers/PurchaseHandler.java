package core.basesyntax.handlers;

public class PurchaseHandler implements Activity {
    @Override
    public int calculateCount(int currentCount, int newCount) {
        int result = currentCount - newCount;
        if (result < 0) {
            throw new RuntimeException("Can't purchase count");
        }
        return result;
    }
}
