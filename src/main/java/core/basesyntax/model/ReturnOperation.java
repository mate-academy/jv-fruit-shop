package core.basesyntax.model;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer handle(Integer quantity) {
        return quantity;
    }
}
