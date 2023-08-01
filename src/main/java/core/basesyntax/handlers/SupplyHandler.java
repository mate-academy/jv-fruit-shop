package core.basesyntax.handlers;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handler(String fruit, int quantity) {
        AddHandler.addToStorage(fruit, quantity);
    }
}
