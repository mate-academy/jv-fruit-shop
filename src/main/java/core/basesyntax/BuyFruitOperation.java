package core.basesyntax;

public class BuyFruitOperation implements FruitOperation {
    private FruitStorage storage;

    @Override
    public void apply(Fruit fruit) {
        storage.remove(fruit);
    }
}
