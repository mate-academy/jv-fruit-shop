package service;

import dao.FruitDao;
import java.util.Optional;
import service.interfaces.FruitOperationService;

public class FruitReturnServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitReturnServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Optional<Integer> currentQuantity = fruitDao.get(transactionDto.getFruit());
        fruitDao.put(transactionDto.getFruit(), currentQuantity.orElse(0)
                + transactionDto.getQuantity());
    }
}
