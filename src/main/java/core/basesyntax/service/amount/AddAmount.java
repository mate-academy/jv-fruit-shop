package core.basesyntax.service.amount;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitRecord;

public class AddAmount implements AmountHandler {
    @Override
    public boolean apply(FruitRecord newFruit) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        FruitRecord currentFruit = fruitsDao.getRecord(newFruit);
        int updatedAmount = currentFruit.getAmount() + newFruit.getAmount();
        FruitRecord fruitRecord = new FruitRecord(updatedAmount,
                newFruit.getType(), newFruit.getFruit());
        return fruitsDao.addRecord(fruitRecord);
    }
}
