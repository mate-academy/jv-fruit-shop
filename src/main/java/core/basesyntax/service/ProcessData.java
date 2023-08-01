package core.basesyntax.service;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;

import java.util.List;
import java.util.Map;

public interface ProcessData<T> {
    void processDate (List<T> data,  Map<Operation, OperationHandler> operationHandlerMap);
}
