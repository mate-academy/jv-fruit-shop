package dev.service.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer update(Integer prev, Integer value) {
        return prev - value;
    }
}
