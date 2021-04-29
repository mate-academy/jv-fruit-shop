package service;

import dao.FruitDao;
import service.interfaces.FruitOperationService;

public class FruitBalanceServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitBalanceServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        fruitDao.put(transactionDto.getFruit(), transactionDto.getQuantity());
    }
}
