package core.basesyntax;

public class SupplyOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer currentSupply = Storage.getFruit(transaction.getFruit());
        Storage.putFruit(transaction.getFruit(), currentSupply + transaction.getQuantity());
    }
}
