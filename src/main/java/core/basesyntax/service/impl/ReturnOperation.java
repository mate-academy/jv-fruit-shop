package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.RecordDataManipulation;

public class ReturnOperation implements RecordDataManipulation {
    private final RecordDao recordDao = RecordDaoImpl.getInstance();

    @Override
    public void operate(Product product) {
        Product productFromDB = recordDao.get(product);
        if (productFromDB == null) {
            throw new RuntimeException("Product not found in DB. ProductName="
                    + product.getName());
        }
        if (recordDao.remove(product)) {
            recordDao.put(product);
        } else {
            productFromDB.setCount(productFromDB.getCount() + product.getCount());
            recordDao.put(productFromDB);
        }
    }
}
