package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitData;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitData fruitData) {
        if (Storage.FRUITS.containsKey(fruitData.getFruitName())) {
            FruitData data = Storage.FRUITS.get(fruitData.getFruitName());
            data.setQuantity(data.getQuantity() + fruitData.getQuantity());
            Storage.FRUITS.put(data.getFruitName(), data);
        } else {
            Storage.FRUITS.put(fruitData.getFruitName(), fruitData);
        }
    }

    @Override
    public void remove(FruitData fruitData) {
        if (Storage.FRUITS.containsKey(fruitData.getFruitName())) {
            FruitData data = Storage.FRUITS.get(fruitData.getFruitName());
            data.setQuantity(data.getQuantity() - fruitData.getQuantity());
            if (data.getQuantity() < 0) {
                throw new RuntimeException("Can't remove more then exists in storage.\nFruit: "
                        + fruitData.getFruitName()
                        + " in storage: " + data.getQuantity() + ". Quantity for removal requested "
                        + fruitData.getQuantity());
            }
            Storage.FRUITS.put(data.getFruitName(), data);
        } else {
            throw new RuntimeException("Fruit does not exists");
        }
    }

    @Override
    public FruitData get(String fruitName) {
        return Storage.FRUITS.get(fruitName);
    }

}
