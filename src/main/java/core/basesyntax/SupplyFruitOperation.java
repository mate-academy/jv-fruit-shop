package core.basesyntax;

public class SupplyFruitOperation implements FruitOperation {
    private FruitStorage storage;

    @Override
    public void apply(Fruit fruit) {
        storage.add(fruit);
    }
}
