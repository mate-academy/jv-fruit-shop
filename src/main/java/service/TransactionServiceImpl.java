package service;

import dao.FruitTransactionDao;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import operation.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;
    private final FruitTransactionDao fruitTransactionDao;

    public TransactionServiceImpl(OperationStrategy operationStrategy,
                                  FruitTransactionDao fruitTransactionDao) {
        this.operationStrategy = operationStrategy;
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public Map<String,Integer> countsFruitsAfterWorkDay() {
        Map<String,Integer> updatedFruitsStockMap = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactionDao.getFruitTransactionList()) {
            updatedFruitsStockMap.put(fruitTransaction.getFruitName(),
                    updatedFruitsStockMap.getOrDefault(fruitTransaction.getFruitName(),0)
                            + operationStrategy.get(fruitTransaction.getOperation())
                                    .getResult(fruitTransaction.getQuantity()));
        }
        return updatedFruitsStockMap;
    }
}
