package service.impl;

import java.util.List;
import dao.FruitDao;
import service.FruitTransactionService;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;

    public FruitTransactionServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makeOperation(List<FruitTransaction> commands) {

    }
}
