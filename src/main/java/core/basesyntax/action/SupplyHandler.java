package core.basesyntax.action;

public class SupplyHandler implements ActionHandler {
    @Override
    public int performAction(int amount) {
        return amount;
    }
}
