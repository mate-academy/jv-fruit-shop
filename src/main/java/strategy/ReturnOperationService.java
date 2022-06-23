package strategy;

import java.util.function.IntUnaryOperator;

public class ReturnOperationService implements OperationHandler {
    @Override
    public IntUnaryOperator getActionByOperation(int quantity) {
        return x -> x + quantity;
    }
}
