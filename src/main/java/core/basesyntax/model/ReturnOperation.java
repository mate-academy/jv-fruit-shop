package core.basesyntax.model;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer makeOperation(Integer quantity) {
        return quantity;
    }
}
