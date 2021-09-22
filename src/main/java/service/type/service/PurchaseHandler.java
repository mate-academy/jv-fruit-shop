package service.type.service;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return result - amount;
    }
}
