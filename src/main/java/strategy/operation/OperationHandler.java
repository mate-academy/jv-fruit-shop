package strategy.operation;

public interface OperationHandler<K, V> {
    void doOperation(K fruit, V quantity);
}
