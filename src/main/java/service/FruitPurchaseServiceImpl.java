package service;

import dao.FruitDao;
import exception.InsufficientAmountException;
import java.util.Optional;
import service.interfaces.FruitOperationService;

public class FruitPurchaseServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitPurchaseServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Optional<Integer> currentQuantity = fruitDao.get(transactionDto.getFruit());
        if (currentQuantity.isPresent() && currentQuantity.get() >= transactionDto.getQuantity()) {
            fruitDao.put(transactionDto.getFruit(), currentQuantity.get()
                    - transactionDto.getQuantity());
            return;
        }
        throw new InsufficientAmountException("Insufficient quantity of goods");
    }
}
