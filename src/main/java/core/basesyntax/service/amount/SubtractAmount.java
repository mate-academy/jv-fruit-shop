package core.basesyntax.service.amount;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitRecord;

public class SubtractAmount implements AmountHandler {
    @Override
    public boolean apply(FruitRecord newFruit) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        FruitRecord currentFruit = fruitsDao.getRecord(newFruit);
        int updatedAmount = currentFruit.getAmount() - newFruit.getAmount();
        if (updatedAmount < 0) {
            throw new RuntimeException("It isn't possible to buy fruits!"
                    + System.lineSeparator()
                    + "Is available: " + currentFruit.getAmount()
                    + " " + currentFruit.getFruit().getFruitName()
                    + System.lineSeparator()
                    + "Trying to buy: " + newFruit.getAmount()
                    + " " + newFruit.getFruit().getFruitName());
        }
        FruitRecord fruitRecord = new FruitRecord(updatedAmount,
                newFruit.getType(), newFruit.getFruit());
        return fruitsDao.updateRecord(fruitRecord);
    }
}
