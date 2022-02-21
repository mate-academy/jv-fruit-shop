package core.fruitshop.service.CalculateHandler;

import core.fruitshop.dao.FruitDaoImpl;
import core.fruitshop.db.Storage;
import core.fruitshop.model.Fruit;

public class CalculatehandlerImpl implements Calculatehandler{
    private final FruitDaoImpl fruitDao;

        public CalculatehandlerImpl(FruitDaoImpl fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void addQuantity(Fruit fruit, int quantity) {
        int prevQuantity = fruitDao.getQuantity(fruit);
        Storage.fruitsStorage.put(fruit, prevQuantity + quantity);
    }

    @Override
    public void subtractQuantity(Fruit fruit, int quantity) {
        int prevQuantity = fruitDao.getQuantity(fruit);
        if (prevQuantity - quantity < 0) {
            throw new RuntimeException("Balance cant be negative");
        }
        Storage.fruitsStorage.put(fruit, prevQuantity - quantity);
    }

}
