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
    public void manipulation(List<FruitTransaction> data) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl();

        for (FruitTransaction transaction : data) {
            if (fruitDao.get(transaction.getFruit()) == null) {
                fruitDao.add(fruitService.createNewFruit(transaction.getFruit()));
            }
            Fruit fruitOperation = fruitDao.get(transaction.getFruit());
            fruitOperation.setQuantity(strategy
                    .getActivity(transaction.getOperation())
                    .operationWithFruit(transaction.getQuantity(), fruitOperation.getQuantity()));
            fruitDao.update(fruitOperation);
        }
    }
}
