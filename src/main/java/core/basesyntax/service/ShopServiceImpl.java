package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Transaction;

public class ShopServiceImpl implements ShopService {
    private final Shop<? extends Transaction> shop;
    private final FruitsDao fruitsDao;

    public ShopServiceImpl(Shop<FruitTransaction> shop, FruitsDao fruitsDao) {
        this.shop = shop;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void generateReport(String report) {
        fruitsDao.writeReportToCsvFile(shop.getReportData());
    }
}
