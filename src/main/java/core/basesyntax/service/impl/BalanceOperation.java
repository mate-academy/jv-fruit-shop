package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.RecordDataManipulation;

public class BalanceOperation implements RecordDataManipulation {
    private final RecordDao recordDao = RecordDaoImpl.getInstance();

    @Override
    public void operate(Product product) {
        Product productFromDB = recordDao.get(product);
        if (productFromDB != null && productFromDB.getCount() > 0) {
            product.setCount(product.getCount() + productFromDB.getCount());
        }
        recordDao.put(product);
    }
}
