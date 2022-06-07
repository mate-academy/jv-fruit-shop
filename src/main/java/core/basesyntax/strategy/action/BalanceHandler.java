package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.model.ProductTransaction;

public class BalanceHandler implements ActionHandler {
    @Override
    public void process(ProductStorageDao productStorageDao, ProductTransaction transaction) {
        productStorageDao.setQuantity(transaction.getProduct(), transaction.getQuantity());
    }
}
