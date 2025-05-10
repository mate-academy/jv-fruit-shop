package dev.service.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer update(Integer prev, Integer value) {
        return prev + value;
    }
}
