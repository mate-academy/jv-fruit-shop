package mate.academy.service.calculation;

import mate.academy.dao.ShopDao;
import mate.academy.dao.ShopDaoImpl;
import mate.academy.model.FruitTransaction;

public class BalanceCalculator implements TransactionCalculation {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        shopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
