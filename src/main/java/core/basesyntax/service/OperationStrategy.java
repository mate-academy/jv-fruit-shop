package core.basesyntax.service;

public interface OperationStrategy {
    OperationHandler getHandler(String operation);
}
