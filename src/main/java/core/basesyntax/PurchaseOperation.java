package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.removeFruit(transaction.getFruit(), transaction.getAmount());
    }
}
