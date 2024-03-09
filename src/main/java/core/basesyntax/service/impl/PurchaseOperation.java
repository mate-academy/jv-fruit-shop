package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.record.Record;
import core.basesyntax.service.DataOperation;

public class PurchaseOperation implements DataOperation {
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public void operate(Record record) {
        Product product = record.product();
        Product productFromDB = recordDao.get(product);
        if (recordDao.remove(product)) {
            recordDao.put(product);
        } else {
            productFromDB.setCount(productFromDB.getCount() - product.getCount());
            recordDao.put(productFromDB);
        }
    }
}
