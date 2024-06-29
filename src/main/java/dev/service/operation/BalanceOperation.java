package dev.service.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer update(Integer prev, Integer value) {
        return value;
    }
}
