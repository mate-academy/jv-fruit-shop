package operation;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
