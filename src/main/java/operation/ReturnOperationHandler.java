package operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getResult(Integer newAmount) {
        return newAmount;
    }
}
