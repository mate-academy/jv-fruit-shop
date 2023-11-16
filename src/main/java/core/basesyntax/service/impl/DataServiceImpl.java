package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.exception.NoSuchOperationException;
import java.util.List;

public class DataServiceImpl implements DataService {
    private final TransactionDao fruitTranslationDao;
    private final TransactionService fruitTransactionService;

    public DataServiceImpl(TransactionDao fruitTranslationDao,
                           TransactionService fruitTransactionService) {
        this.fruitTranslationDao = fruitTranslationDao;
        this.fruitTransactionService = fruitTransactionService;
    }

    @Override
    public String processingTransaction(List<String> linesBalance) {

        for (String s : linesBalance) {
            FruitTransaction transaction = fruitTransactionService.createInstance(s);
            if (isExistTransaction(transaction)) {
                fruitTransactionService.updateTransaction(transaction);
            } else {
                fruitTransactionService.createNewTransaction(transaction);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity");
        sb.append(System.lineSeparator());
        sb.append(getTotalBalance(Fruit.APPLE));
        sb.append(System.lineSeparator());
        sb.append(getTotalBalance(Fruit.BANANA));

        return sb.toString();
    }

    private String getTotalBalance(Fruit fruit) {
        List<FruitTransaction> list = fruitTranslationDao.getAll();
        int balance = 0;
        for (FruitTransaction transaction : list) {
            if (transaction.getFruit() == fruit) {
                if (transaction.getOperation() == Operation.BALANCE
                        || transaction.getOperation() == Operation.SUPPLY
                        || transaction.getOperation() == Operation.RETURN) {
                    balance += transaction.getQuantity();
                }
                if (transaction.getOperation() == Operation.PURCHASE) {
                    balance -= transaction.getQuantity();
                }
            }
        }
        if (balance < 0) {
            throw new RuntimeException("Balance shouldn't be negative");
        }
        return fruit.name().toLowerCase() + "," + balance;
    }

    private boolean isExistTransaction(FruitTransaction transaction) {
        try {
            fruitTransactionService.findTransactionByOperationAndFruit(transaction);
        } catch (NoSuchOperationException e) {
            return false;
        }
        return true;
    }
}
