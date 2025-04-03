package core.basesyntax;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getAmount());
    }
}
