package service.type.service;

public class ReturnHandler implements OperationHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return amount + result;
    }
}
