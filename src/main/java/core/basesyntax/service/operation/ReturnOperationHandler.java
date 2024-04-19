package core.basesyntax.service.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer calculateQuantity(Integer before, Integer after) {
        return before + after;
    }
}
