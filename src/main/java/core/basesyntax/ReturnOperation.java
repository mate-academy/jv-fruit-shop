package core.basesyntax;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getAmount());
    }
}
