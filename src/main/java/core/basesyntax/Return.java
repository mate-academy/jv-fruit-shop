package core.basesyntax;

public class Return extends Operation {
    @Override
    public void toDo(FruitPackage fruitPackage, Storage storage) {
        storage.getFruitPackages().add(fruitPackage);
    }
}
