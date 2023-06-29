package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

public class PurchaseDataService implements DataService {
    private final FruitService fruitService = new FruitServiceImpl();
    private FruitDao fruitDao;

    public PurchaseDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);
        Fruit fruit = fruitService.createNewFruit(fruitTransaction.getFruit());
        if (!fruitDao.getAll().containsKey(fruit)) {
            throw new RuntimeException("There is no fruit " + fruitTransaction.getFruit()
                    + " for purchase.");
        }

        int availableQuantity = fruitDao.getFruitQuantity(fruitTransaction.getFruit());
        int requiredQuantity = fruitTransaction.getQuantity();

        if (availableQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough quantity in storage for fruit "
                    + fruitTransaction.getFruit() + " purchase. Required: "
                    + requiredQuantity + ", available: "
                    + availableQuantity);
        }

        fruitDao.add(fruit, availableQuantity - requiredQuantity);
    }
}
