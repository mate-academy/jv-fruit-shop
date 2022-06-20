package core.basesyntax.service.actiontype;

public class ActionStrategySupplier implements ActionType {
    @Override
    public int getNewValue(int value) {
        return value;
    }
}
