package core.service;

import core.service.handlers.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(String operation);
}
