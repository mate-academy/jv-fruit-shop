package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.model.ProductTransaction;

public class ReturnHandler implements ActionHandler {
    @Override
    public void process(ProductStorageDao productStorageDao, ProductTransaction transaction) {
        new SupplyHandler().process(productStorageDao, transaction);
    }
}
