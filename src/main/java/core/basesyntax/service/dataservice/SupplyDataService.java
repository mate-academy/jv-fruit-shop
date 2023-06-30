package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyDataService implements DataService {
    private FruitDao fruitDao;

    public SupplyDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);
        String fruitName = fruitTransaction.getFruitName();
        int availableQuantity = fruitDao.getFruitQuantity(fruitTransaction.getFruitName());
        int suppliedQuantity = fruitTransaction.getQuantity();
        fruitDao.put(fruitName, availableQuantity + suppliedQuantity);
    }
}
