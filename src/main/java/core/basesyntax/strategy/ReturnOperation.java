package core.basesyntax.strategy;

public class ReturnOperation implements OperationHandler {
    @Override
    public int getStock(int amount) {
        return amount;
    }
}
