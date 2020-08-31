package core.basesyntax;

public class Return extends Operation {
    @Override
    public void apply(FruitPackage fruitPackage, Storage storage) {
        storage.getFruitPackages().add(fruitPackage);
    }
}
