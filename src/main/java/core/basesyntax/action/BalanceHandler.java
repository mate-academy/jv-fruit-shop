package core.basesyntax.action;

public class BalanceHandler implements ActionHandler {
    @Override
    public int performAction(int amount) {
        return amount;
    }
}
