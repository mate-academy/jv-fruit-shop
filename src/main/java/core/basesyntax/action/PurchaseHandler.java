package core.basesyntax.action;

public class PurchaseHandler implements ActionHandler {
    @Override
    public int performAction(int amount) {
        return -amount;
    }
}
