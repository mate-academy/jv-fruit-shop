package service;

import model.*;
import operations.*;

public interface OperationStrategy {
    /**
     * Get Operation handler.
     * @param operation type of operation.
     * @return Handler fo certain operation.
     */
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
