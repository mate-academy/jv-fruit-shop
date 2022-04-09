package core.basesyntax.service.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int operationWithFruit(int fruitTo, int fruitFrom) {
        return fruitFrom - fruitTo;
    }

}
