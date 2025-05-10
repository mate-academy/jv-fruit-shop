package db;

public class FruitStorageDao implements StorageDao<String,Integer> {
    private static final String REPORT_HEAD = "fruit,quantity";
    private final FruitStorage fruitStorage;

    public FruitStorageDao(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void put(String fruit, Integer value) {
        fruitStorage.getFruits().put(fruit, value);
    }

    @Override
    public boolean remove(String fruit, Integer count) {
        return fruitStorage.getFruits().remove(fruit, count);
    }

    @Override
    public Integer getValue(String fruit) {
        return fruitStorage.getFruits().get(fruit);
    }
}
