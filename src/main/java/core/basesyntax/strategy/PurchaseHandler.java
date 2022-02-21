package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.dto.FruitDto;

public class PurchaseHandler implements Operation {

    @Override
    public void process(FruitDto fruit) {
        FruitDao storageDao = new FruitDaoImpl();
        if (storageDao.getValue(fruit) == null) {
            return;
        }
        fruit.setQuantity(storageDao.getValue(fruit) - fruit.getQuantity());
        storageDao.save(fruit);
    }
}
