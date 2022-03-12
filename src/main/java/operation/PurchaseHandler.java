package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.Fruit;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void proceed(Fruit fruit) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruit) == null) {
            return;
        }
        fruit.setQuantity(fruitShopDao.getValue(fruit) - fruit.getQuantity());
        fruitShopDao.save(fruit);
    }
}


