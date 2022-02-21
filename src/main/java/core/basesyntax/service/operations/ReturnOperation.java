package core.basesyntax.service.operations;

public class ReturnOperation implements FruitOperation {
    @Override
    public void operation(String[] data) {
        increaseQuantity(data);
    }
}
