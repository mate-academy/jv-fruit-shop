package core.basesyntax.service.impl;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void add(Fruit fruit, int amount) {
        Map<Fruit, Integer> fruits = shopDao.getFruits();
        if (fruits.keySet().contains(fruit)) {
            fruits.replace(new Fruit(fruit.getName()),
                    fruits.get(fruit),
                    amount + fruits.get(fruit));
        } else {
            shopDao.add(fruit, amount);
        }
    }

    @Override
    public int get(Fruit fruit, int amount) {
        Map<Fruit, Integer> fruits = shopDao.getFruits();
        if (!fruits.keySet().contains(fruit)) {
            throw new RuntimeException("Such fruit is absent in the shop");
        }
        return fruits.get(fruit);
    }

}
