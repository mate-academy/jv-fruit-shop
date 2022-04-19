package operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer getResult(Integer newAmount) {
        return - newAmount;
    }
}
