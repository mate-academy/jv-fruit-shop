package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

public class BalanceDataService implements DataService {
    private final FruitService fruitService = new FruitServiceImpl();
    private FruitDao fruitDao;

    public BalanceDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);

        Fruit fruit = fruitService.createNewFruit(fruitTransaction.getFruit());
        if (fruitDao.getAll().containsKey(fruit)) {
            throw new RuntimeException("You can't override current balance for "
                    + fruitTransaction.getFruit());
        }
        fruitDao.add(fruit, fruitTransaction.getQuantity());
    }
}
