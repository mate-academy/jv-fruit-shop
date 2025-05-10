package core.basesyntax.db;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void saveOrUpdate(String fruitName, Integer quantity) {
        FruitStorage.addElement(fruitName, quantity);

    }

    @Override
    public Integer getFruitQuantity(String fruitName) {
        return FruitStorage.getFruitFromStorage(fruitName);
    }
}
