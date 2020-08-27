package core.basesyntax;

public class Supply extends Operation {
    @Override
    public void toDo(Fruit fruit, Storage storage) {
        storage.getFruits().add(fruit);
    }
}
