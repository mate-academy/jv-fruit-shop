package core.basesyntax.service.actiontype;

public class ActionStrategyS implements ActionType {
    @Override
    public int getNewValue(int value) {
        return value;
    }
}
