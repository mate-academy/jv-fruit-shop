package core.basesyntax.service.actiontype;

public class ActionStrategyP implements ActionType {
    @Override
    public int getNewValue(int value) {
        return value * (-1);
    }
}
