package core.basesyntax.service.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public int operationWithFruit(int fruitTo, int fruitFrom) {
        return fruitTo + fruitFrom;
    }
}
