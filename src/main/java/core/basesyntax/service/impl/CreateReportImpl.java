package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.service.CreateReport;
import java.util.ArrayList;
import java.util.List;

public class CreateReportImpl implements CreateReport {
    private FruitShopDao fruitShopDao;

    public CreateReportImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    public FruitShopDao getFruitShopDao() {
        return fruitShopDao;
    }

    public void setFruitShopDao(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<String> create() {
        List<String> list = new ArrayList<>();
        list.add("fruit,quantity");
        list.addAll(fruitShopDao.getAll());
        return list;
    }
}
