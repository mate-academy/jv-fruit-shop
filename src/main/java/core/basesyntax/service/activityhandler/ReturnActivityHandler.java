package core.basesyntax.service.activityhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class ReturnActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public ReturnActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruitToReturn) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruitToReturn);
        if (fruitFromDB.isPresent()) {
            long newAmount = fruitFromDB.get().getBalance() + fruitToReturn.getBalance();
            fruitDao.add(fruitToReturn.setAmount(newAmount));
            return newAmount;
        }
        fruitDao.add(fruitToReturn);
        return fruitToReturn.getBalance();
    }
}
