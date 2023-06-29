package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

public class ReturnDataService implements DataService {
    private final FruitService fruitService = new FruitServiceImpl();
    private FruitDao fruitDao;

    public ReturnDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);
        Fruit fruit = fruitService.createNewFruit(fruitTransaction.getFruit());
        int availableQuantity = fruitDao.getFruitQuantity(fruitTransaction.getFruit());
        int returnedQuantity = fruitTransaction.getQuantity();
        fruitDao.add(fruit, availableQuantity + returnedQuantity);
    }
}
