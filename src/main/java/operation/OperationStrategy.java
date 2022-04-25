package operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String operation);
}
