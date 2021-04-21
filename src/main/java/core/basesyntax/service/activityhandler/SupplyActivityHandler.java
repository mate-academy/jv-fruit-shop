package core.basesyntax.service.activityhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class SupplyActivityHandler implements ActivityHandler {
    private FruitDao fruitDao;

    public SupplyActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public long changeBalance(Fruit fruitToSupply) {
        Optional<Fruit> fruitFromDB = fruitDao.get(fruitToSupply);
        if (fruitFromDB.isPresent()) {
            long newAmount = fruitFromDB.get().getBalance() + fruitToSupply.getBalance();
            fruitDao.add(fruitToSupply.setAmount(newAmount));
            return newAmount;
        }
        fruitDao.add(fruitToSupply);
        return fruitToSupply.getBalance();
    }
}
