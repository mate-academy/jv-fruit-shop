package strategy;

import java.util.function.IntUnaryOperator;

public class SupplyOperationService implements OperationHandler {
    @Override
    public IntUnaryOperator getActionByOperation(int quantity) {
        return x -> x + quantity;
    }
}
