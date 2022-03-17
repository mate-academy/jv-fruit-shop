package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.Fruit;

public class PurchaseHandler implements Operation {
    @Override
    public void proceed(Fruit fruit) {
        if (fruit.getFruit().isEmpty()
                || fruit.getOperation() == null
                || fruit.getFruit() == null) {
            throw new NullPointerException("This line cannot be empty");
        }
        if (fruit.getQuantity() < 0) {
            throw new RuntimeException("The amount cannot be negative");
        }
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruit) == null) {
            return;
        }
        fruit.setQuantity(fruitShopDao.getValue(fruit) - fruit.getQuantity());
        fruitShopDao.save(fruit);
    }
}


