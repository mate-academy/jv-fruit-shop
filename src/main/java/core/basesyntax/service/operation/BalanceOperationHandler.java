package core.basesyntax.service.operation;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public Integer calculateQuantity(Integer before, Integer after) {
        return after;
    }
}
