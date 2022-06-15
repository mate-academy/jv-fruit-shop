package mate.academy.service.calculation;

import mate.academy.dao.ShopDao;
import mate.academy.dao.ShopDaoImpl;
import mate.academy.model.FruitTransaction;
import mate.academy.storage.Storage;

public class SupplyCalculator implements TransactionCalculation {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        shopDao.add(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + Storage.storage.get(fruitTransaction.getFruit()));
    }
}
