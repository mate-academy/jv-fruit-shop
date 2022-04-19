package operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer getResult(Integer newAmount) {
        return newAmount;
    }
}
