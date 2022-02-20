package core.basesyntax.service.handler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int quantityFromFile) {
        return currentQuantity + quantityFromFile;
    }
}
