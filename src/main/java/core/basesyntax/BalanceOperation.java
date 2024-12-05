package core.basesyntax;

public class BalanceOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
