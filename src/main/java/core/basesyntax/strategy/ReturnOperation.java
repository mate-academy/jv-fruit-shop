package core.basesyntax.strategy;

public class ReturnOperation implements OperationHandler {
    @Override
    public int warehouse(int balance, int quantity) {
        return balance + quantity;
    }
}
