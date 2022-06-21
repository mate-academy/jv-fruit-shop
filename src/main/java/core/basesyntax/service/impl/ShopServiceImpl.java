package core.basesyntax.service.impl;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void add(String fruit, int amount) {
        Map<String, Integer> fruits = shopDao.getFruits();
        if (fruits.containsKey(fruit)) {
            fruits.put(fruit,
                    amount + fruits.get(fruit));
        } else {
            shopDao.add(fruit, amount);
        }
    }

    @Override
    public int get(String fruit, int amount) {
        Map<String, Integer> fruits = shopDao.getFruits();
        if (!fruits.containsKey(fruit)) {
            throw new RuntimeException("Such fruit is absent in the shop");
        }
        return fruits.get(fruit);
    }
}
