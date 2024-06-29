package dev.service.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer update(Integer prev, Integer value) {
        return prev + value;
    }
}
