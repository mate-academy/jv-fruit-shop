package strategy;

import java.util.function.IntUnaryOperator;

public class PurchaseOperationService implements OperationHandler {
    @Override
    public IntUnaryOperator getActionByOperation(int quantity) {
        return x -> x - quantity;
    }
}
