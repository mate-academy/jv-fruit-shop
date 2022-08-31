package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(Fruit fruit) {
        if (Storage.FRUITS.containsKey(fruit.getFruitName())) {
            Fruit data = Storage.FRUITS.get(fruit.getFruitName());
            data.setQuantity(data.getQuantity() + fruit.getQuantity());
            Storage.FRUITS.put(data.getFruitName(), data);
        } else {
            Storage.FRUITS.put(fruit.getFruitName(), fruit);
        }
    }

    @Override
    public void subtract(Fruit fruit) {
        if (Storage.FRUITS.containsKey(fruit.getFruitName())) {
            Fruit data = Storage.FRUITS.get(fruit.getFruitName());
            data.setQuantity(data.getQuantity() - fruit.getQuantity());
            if (data.getQuantity() < 0) {
                throw new RuntimeException("Can't remove more then exists in storage.\nFruit: "
                        + fruit.getFruitName()
                        + " in storage: " + data.getQuantity() + ". Quantity for removal requested "
                        + fruit.getQuantity());
            }
            Storage.FRUITS.put(data.getFruitName(), data);
        } else {
            throw new RuntimeException("Fruit does not exists");
        }
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.FRUITS.get(fruitName);
    }

}
