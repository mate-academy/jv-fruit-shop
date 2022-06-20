package core.basesyntax.service.actiontype;

public class ActionStrategyReturner implements ActionType {
    @Override
    public int getNewValue(int value) {
        return value;
    }
}
