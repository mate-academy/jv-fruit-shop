package strategy;

public interface OperationStrategy {
    OperationHandler get(String codeOperation);
}
