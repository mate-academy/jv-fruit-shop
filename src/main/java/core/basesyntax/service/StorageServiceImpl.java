package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;

public class StorageServiceImpl implements StorageService {
    private final FruitTransactionDao fruitTransactionDao;

    public StorageServiceImpl(){
        fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    @Override
    public void fillActivityStorage(ArrayList<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            fruitTransactionDao.add(fruitTransaction);
        }
    }

}
