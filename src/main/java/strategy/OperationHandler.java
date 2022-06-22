package strategy;

import java.util.function.IntUnaryOperator;

public interface OperationHandler {
    IntUnaryOperator getActionByOperation(int quantity);
}
