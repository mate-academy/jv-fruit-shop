package operation;

public interface OperationStrategy {
    Operation getOperation(OperationType type);
}
