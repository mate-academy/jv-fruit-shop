package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.FruitTransaction;

public class SupplyHandler implements Operation {
    @Override
    public boolean proceed(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruitTransaction) == null) {
            fruitShopDao.save(fruitTransaction);
        }
        fruitTransaction.setQuantity(fruitShopDao.getValue(fruitTransaction)
                + fruitTransaction.getQuantity());
        fruitShopDao.save(fruitTransaction);
        return true;
    }
}
