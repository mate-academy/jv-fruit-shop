package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.Fruit;

public class SupplyHandler implements Operation {
    @Override
    public void proceed(Fruit fruit) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruit) == null) {
            fruitShopDao.save(fruit);
        }
        if (fruit.getQuantity() == 0
                || fruit.getFruit().isEmpty()
                || fruit.getOperation() == null
                || fruit.getFruit() == null) {
            throw new NullPointerException("This line cannot be empty");
        }
        if (fruit.getQuantity() < 0) {
            throw new RuntimeException("The amount cannot be negative");
        }
        fruit.setQuantity(fruitShopDao.getValue(fruit) + fruit.getQuantity());
        fruitShopDao.save(fruit);
    }
}


