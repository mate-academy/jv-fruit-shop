package core.basesyntax;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
