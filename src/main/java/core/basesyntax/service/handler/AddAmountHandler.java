package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class AddAmountHandler implements RecordHandler {
    private final FruitDao fruitDao;

    public AddAmountHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruit) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruit);
        if (fruitFromDB.isPresent()) {
            long newBalance = fruitFromDB.get().getAmount() + fruit.getAmount();
            fruit.setAmount(newBalance);
            fruitDao.save(fruit);
            return newBalance;
        }
        fruitDao.save(fruit);
        return fruit.getAmount();
    }
}
