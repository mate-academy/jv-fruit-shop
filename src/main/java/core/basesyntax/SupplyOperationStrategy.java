package core.basesyntax;

public class SupplyOperationStrategy implements OperationStrategy {
    @Override
    public void process(FruitTransaction transaction, FruitStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
