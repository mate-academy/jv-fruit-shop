package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseDataService implements DataService {
    private FruitDao fruitDao;

    public PurchaseDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);
        String fruitName = fruitTransaction.getFruitName();
        if (!fruitDao.getAll().containsKey(fruitName)) {
            throw new RuntimeException("There is no fruit " + fruitTransaction.getFruitName()
                    + " for purchase.");
        }

        int availableQuantity = fruitDao.getFruitQuantity(fruitTransaction.getFruitName());
        int requiredQuantity = fruitTransaction.getQuantity();

        if (availableQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough quantity in storage for fruit "
                    + fruitTransaction.getFruitName() + " purchase. Required: "
                    + requiredQuantity + ", available: "
                    + availableQuantity);
        }

        fruitDao.put(fruitName, availableQuantity - requiredQuantity);
    }
}
