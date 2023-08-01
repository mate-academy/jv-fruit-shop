package core.basesyntax.handlers;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handler(String fruit, int quantity) {
       AddFruitsToStorage.addToStorage(fruit, quantity);
    }
}
