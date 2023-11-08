package core.basesyntax.dao.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity;
    }
}
