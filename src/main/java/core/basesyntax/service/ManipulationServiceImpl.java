package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ManipulationServiceImpl implements ManipulationService {
    private TransactionStrategy strategy;

    public ManipulationServiceImpl(TransactionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void manipulation(List<FruitTransaction> fruitTransactions) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        for (FruitTransaction transaction : fruitTransactions) {
            if (fruitDao.get(transaction.getFruit()) == null) {
                fruitService.createNewFruit(transaction.getFruit());
            }
            Fruit fruitOperation = fruitDao.get(transaction.getFruit());
            int fruitSummary = strategy
                    .getActivity(transaction.getOperation())
                    .process(transaction.getQuantity(), fruitOperation.getQuantity());
            fruitOperation = new Fruit(fruitSummary,transaction.getFruit());
            fruitDao.update(fruitOperation);
        }
    }
}
