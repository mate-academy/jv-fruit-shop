package core.basesyntax.service.operations;

public class SupplyOperation implements FruitOperation {
    @Override
    public void operation(String[] data) {
        increaseQuantity(data);
    }
}
