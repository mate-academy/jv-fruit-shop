package core.basesyntax.strategy;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public int getResultOfOperation(int quantity) {
        return quantity;
    }
}
