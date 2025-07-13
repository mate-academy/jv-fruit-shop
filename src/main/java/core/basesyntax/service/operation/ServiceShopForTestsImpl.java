package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ServiceShopForTestsException;

public class ServiceShopForTestsImpl implements ServiceShopForTests {
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    @Override
    public FruitTransaction shopTest(FruitTransaction fruitTransaction)
            throws ServiceShopForTestsException {
        if (fruitTransaction.getFruit() == null) {
            throw new ServiceShopForTestsException("Null fruit exception!");
        }
        if (fruitTransaction.getOperation() == null) {
            throw new ServiceShopForTestsException("Null Operation exception!");
        }
        if (fruitTransaction.getFruit().isEmpty()) {
            throw new ServiceShopForTestsException("Fruit paramateres are empty!");
        }
        if (fruitTransaction.getAmount() <= 0) {
            throw new ServiceShopForTestsException("Amount can't be less than 1!");
        }
        if (!Character.isLetter(fruitTransaction.getFruit().charAt(0))) {
            throw new ServiceShopForTestsException("Fruit name should start from letters!");
        }
        if (fruitTransaction.getFruit().length() < 4) {
            throw new ServiceShopForTestsException("Fruit name should be atleast 4 letters!");
        }
        if (Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0)
                - fruitTransaction.getAmount() < 0) {
            throw new ServiceShopForTestsException("Fruit amount is not enough!");
        }
        fruitShopDao.add(fruitTransaction.getFruit(), fruitTransaction.getAmount());
        return fruitTransaction;
    }
}
