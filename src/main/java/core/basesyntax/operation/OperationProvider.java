package core.basesyntax.operation;

public interface OperationProvider {
    StoreOperation.Operation get(String operation);
}
