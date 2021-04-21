package core.basesyntax.service.activityhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class PurchaseActivityHandler implements ActivityHandler {
    private FruitDao fruitDao;

    public PurchaseActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruit) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruit);
        if (fruitFromDB.isEmpty() || fruitFromDB.get().getBalance() < fruit.getBalance()) {
            throw new IllegalArgumentException("You can't buy more fruits then the store contains");
        }
        long newBalance = fruitFromDB.get().getBalance() - fruit.getBalance();
        fruitDao.add(fruit.setAmount(newBalance));
        return newBalance;
    }
}
