package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.dto.FruitDto;

public class ReturnHandler implements Operation {

    @Override
    public void process(FruitDto fruit) {
        FruitDao storageDao = new FruitDaoImpl();
        if (storageDao.getValue(fruit) == null) {
            storageDao.save(fruit);
        }
        fruit.setQuantity(storageDao.getValue(fruit) + fruit.getQuantity());
        storageDao.save(fruit);
    }
}
