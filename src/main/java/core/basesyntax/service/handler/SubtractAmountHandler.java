package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class SubtractAmountHandler implements RecordHandler {
    private FruitDao fruitDao;

    public SubtractAmountHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruit) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruit.getName());
        if (fruitFromDB.isEmpty() || fruitFromDB.get().getAmount() < fruit.getAmount()) {
            throw new IllegalArgumentException("You can't buy more fruits then the store contains");
        }
        long newBalance = fruitFromDB.get().getAmount() - fruit.getAmount();
        fruit.setAmount(newBalance);
        fruitDao.save(fruit);
        return newBalance;
    }
}
