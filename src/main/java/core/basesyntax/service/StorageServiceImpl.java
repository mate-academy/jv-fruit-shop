package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final FruitTransactionDao fruitTransactionDao;

    public StorageServiceImpl() {
        fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    @Override
    public void fillActivityStorage(List<FruitTransaction> list) {
        if (list == null) {
            throw new RuntimeException("");
        }

        for (FruitTransaction fruitTransaction : list) {
            fruitTransactionDao.add(fruitTransaction);
        }
    }

}
