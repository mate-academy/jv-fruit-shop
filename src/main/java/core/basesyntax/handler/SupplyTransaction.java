package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class SupplyTransaction implements TransactionHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int amount = fruitDao.get(transaction.getFruitName());
        fruitDao.add(transaction.getFruitName(), amount + transaction.getAmount());

    }
}
