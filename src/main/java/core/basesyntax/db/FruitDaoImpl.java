package core.basesyntax.db;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addOrUpdateFruitToStorage(String fruitName, Integer quantity) {
        FruitStorage.fruitsStorage.put(fruitName, quantity);

    }

    @Override
    public Integer getFruitQuantity(String fruitName) {
        return FruitStorage.fruitsStorage.get(fruitName);
    }
}
