package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void addFruitsFromList(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruit : fruitTransactionList){
            fruitDao.add(fruit);
        }
    }
}
