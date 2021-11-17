package core.basesyntax.strategy.activity;

public class ReturnActivityHandler implements ActivityHandler {
    @Override
    public int get(int quantity) {
        return quantity;
    }
}
