package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.model.ProductTransaction;

public interface ActionHandler {
    void process(ProductStorageDao productStorageDao, ProductTransaction transaction);
}
