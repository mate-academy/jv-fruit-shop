package service.type.service;

public class SupplyHandler implements OperationHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return amount + result;
    }
}
