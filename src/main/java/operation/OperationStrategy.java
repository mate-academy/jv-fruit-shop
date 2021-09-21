package operation;

public interface OperationStrategy {
    OperationHandler operate(String operationType);
}
