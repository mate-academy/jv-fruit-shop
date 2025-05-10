package core.basesyntax.service.operations;

import core.basesyntax.db.StockDao;
import core.basesyntax.db.StockDaoStorageImpl;

public class Purchase implements Operation {
    private final StockDao stockDao = new StockDaoStorageImpl();

    @Override
    public void update(String product, Integer amount) {
        stockDao.decrease(product, amount);
    }
}
