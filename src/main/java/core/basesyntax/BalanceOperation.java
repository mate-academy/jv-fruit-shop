package core.basesyntax;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getAmount());
    }
}
