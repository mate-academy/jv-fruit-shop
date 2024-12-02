package core.basesyntax.db;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addOrUpdateFruitToStorage(String fruitName, Integer quantity) {
        FruitStorage.FRUITS_STORAGE.put(fruitName, quantity);

    }

    @Override
    public Integer getFruitQuantity(String fruitName) {
        return FruitStorage.FRUITS_STORAGE.get(fruitName);
    }
}
