package core.basesyntax.service.activityhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class BalanceActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public BalanceActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruit) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruit);
        if (fruitFromDB.isPresent()) {
            long newBalance = fruitFromDB.get().getBalance() + fruit.getBalance();
            fruitDao.add(fruit.setAmount(newBalance));
            return newBalance;
        }
        fruitDao.add(fruit);
        return fruit.getBalance();
    }
}
