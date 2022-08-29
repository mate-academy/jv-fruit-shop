package core.basesyntax.strategy;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public int getResultOfOperation(int quantity) {
        return quantity;
    }
}
