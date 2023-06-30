package core.basesyntax.service.dataservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceDataService implements DataService {
    private FruitDao fruitDao;

    public BalanceDataService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        validateFruitTransaction(fruitTransaction);

        String fruitName = fruitTransaction.getFruitName();
        if (fruitDao.getAll().containsKey(fruitTransaction.getFruitName())) {
            throw new RuntimeException("You can't override current balance for "
                    + fruitTransaction.getFruitName());
        }
        fruitDao.put(fruitName, fruitTransaction.getQuantity());
    }
}
