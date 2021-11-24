package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private FruitShopDao fruitShopDao;

    public ReportServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : fruitShopDao.getAll().entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
