package core.basesyntax.service;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.Parser;
import core.basesyntax.strategy.ActivitiesStrategy;

public class ShopServiceImpl implements ShopService {
    private final ShopDao shopDao;
    private final ActivitiesStrategy activitiesStrategy;
    Parser parser;

    public ShopServiceImpl(ShopDao shopDao, ActivitiesStrategy activitiesStrategy, Parser parser) {
        this.shopDao = shopDao;
        this.activitiesStrategy = activitiesStrategy;
        this.parser = parser;
    }

    @Override
    public void report() {
        for (String line: shopDao.readData()) {
            FruitTransaction fruitTransaction = parser.parse(line);
            activitiesStrategy.get(fruitTransaction.getOperation())
                    .act(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        shopDao.writeReport();
    }
}
