package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.RecordDataManipulation;

public class SupplyOperation implements RecordDataManipulation {
    private final RecordDao recordDao = RecordDaoImpl.getInstance();

    @Override
    public void operate(Product product) {
        Product productFromDB = recordDao.get(product);
        if (recordDao.remove(product)) {
            recordDao.put(product);
        } else {
            productFromDB.setCount(productFromDB.getCount() + product.getCount());
            recordDao.put(productFromDB);
        }
    }
}
