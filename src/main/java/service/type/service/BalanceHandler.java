package service.type.service;

public class BalanceHandler implements OperationHandler {

    @Override
    public int getType(Integer amount, Integer result) {
        return amount;
    }
}
