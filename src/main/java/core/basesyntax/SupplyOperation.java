package core.basesyntax;

public class SupplyOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
