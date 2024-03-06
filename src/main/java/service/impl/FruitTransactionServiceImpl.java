package service.impl;

import dao.FruitDao;
import model.Fruit;
import model.FruitTransaction;
import model.Operation;
import service.FruitTransactionService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;

    public FruitTransactionServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<FruitTransaction> processFruitTransaction(List<FruitTransaction> fruitTransactions) {
        List<FruitTransaction> processedCommands = new ArrayList<>();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            if (fruitTransaction.getOperation().equals(Operation.BALANCE)) {
                Fruit fruit = new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                fruit.setSold(0);
                fruitDao.add(fruit);
            } else {
                processedCommands.add(fruitTransaction);
            }
        }
        return processedCommands;
    }
}
