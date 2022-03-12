package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.Fruit;

public class SupplyHandler implements OperationHandler {
    @Override
    public void proceed(Fruit fruit) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruit) == null) {
            fruitShopDao.save(fruit);
        }
        fruit.setQuantity(fruitShopDao.getValue(fruit) + fruit.getQuantity());
        fruitShopDao.save(fruit);
    }
}


