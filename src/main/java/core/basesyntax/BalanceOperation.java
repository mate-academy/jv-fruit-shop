package core.basesyntax;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.putFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
