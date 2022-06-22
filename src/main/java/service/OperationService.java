package service;

import java.util.function.IntUnaryOperator;

public interface OperationService {
    IntUnaryOperator getActionByOperation(int quantity);
}
