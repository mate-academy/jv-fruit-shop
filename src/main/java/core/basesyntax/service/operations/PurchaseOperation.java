package core.basesyntax.service.operations;

public class PurchaseOperation implements FruitOperation {
    @Override
    public void operation(String[] data) {
        reduceQuantity(data);
    }
}
