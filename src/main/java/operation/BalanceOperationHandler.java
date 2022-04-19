package operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getResult(Integer newAmount) {
        return newAmount;
    }
}
