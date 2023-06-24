package core.basesyntax.service.handler;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer handle(int quantity) {
        return quantity;
    }
}
