package operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.FruitTransaction;

public class PurchaseHandler implements Operation {
    @Override
    public Operation proceed(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruitTransaction) == null) {
            return null;
        }
        fruitTransaction.setQuantity(fruitShopDao.getValue(fruitTransaction)
                - fruitTransaction.getQuantity());
        fruitShopDao.save(fruitTransaction);
        return null;
    }
}


