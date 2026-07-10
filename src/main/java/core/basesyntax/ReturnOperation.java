package core.basesyntax;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer currentAmount = Storage.getFruit(transaction.getFruit());
        Storage.putFruit(transaction.getFruit(), currentAmount + transaction.getQuantity());
    }
}
