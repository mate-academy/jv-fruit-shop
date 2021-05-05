package core.basesyntax.shop.implementation;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.shop.Fruit;

public class Operation {
    private ShopDao shopDao;
    private ActivitieStrategyImpl strategy;

    public Operation() {
        shopDao = new ShopDaoImpl();
    }

    public boolean operateData(StringSplitter splitter) {
        strategy = new ActivitieStrategyImpl();
        Fruit fruit = new Fruit(splitter.getFruit().getName());
        int amount = strategy.get(splitter.getTypeOfOperation())
                .calculateCount(shopDao.get(fruit), splitter.getCount());

        shopDao.add(splitter.getFruit(),amount);
        return true;
    }
}
