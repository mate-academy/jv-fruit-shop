package service;

public interface OperationHandlerStrategy {
    AmountHandler get(Operation operation);
}
