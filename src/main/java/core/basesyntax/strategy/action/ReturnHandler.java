package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.ProductTransaction;

public class ReturnHandler implements ActionHandler {
    @Override
    public void runAction(ProductDao productDao, ProductTransaction productTransaction) {
        new SupplyHandler().runAction(productDao, productTransaction);
    }
}
