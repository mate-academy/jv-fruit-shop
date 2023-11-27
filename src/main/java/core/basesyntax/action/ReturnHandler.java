package core.basesyntax.action;

public class ReturnHandler implements ActionHandler {
    @Override
    public int performAction(int amount) {
        return amount;
    }
}
