package core.basesyntax;

public class ReturnOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
