package operation;

public interface OperationStrategy {
    OperationHandler get(String operationType);
}
