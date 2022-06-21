package core.basesyntax.service.actiontype;

public class ActionStrategyProducer implements ActionType {
    @Override
    public int getNewValue(int value) {
        return value * (-1);
    }
}
