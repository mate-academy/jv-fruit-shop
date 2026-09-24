package core.basesyntax.dao;

public class FruitsDaoImpl implements FruitsDao {
    private final Storage storage;

    public FruitsDaoImpl() {
        this.storage = new Storage();;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

    @Override
    public void addFruitToStorage(String key, Integer value) {
        storage.addToStorage(key,value);
    }

    @Override
    public Integer getFruitFromStorage(String fruitName) {
        return storage.getFromStorage(fruitName);
    }
}
