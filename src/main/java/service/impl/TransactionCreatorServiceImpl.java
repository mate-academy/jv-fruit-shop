package service.impl;

import java.util.ArrayList;
import java.util.List;
import service.TransactionCreatorService;
import service.TransactionService;

public class TransactionCreatorServiceImpl implements TransactionCreatorService {
    private List<TransactionService> fruitTransactionListService;

    public TransactionCreatorServiceImpl() {
        this.fruitTransactionListService = new ArrayList<>();
    }

    public List<TransactionService> getFruitTransactionList() {
        return fruitTransactionListService;
    }

    @Override
    public void creteTransactionsList(List<String> linesFromFile) {
        for (String line : linesFromFile) {
            TransactionService newFruitTransactionService = new TransactionServiceImpl();
            newFruitTransactionService.createTransaction(line);
            getFruitTransactionList().add(newFruitTransactionService);
        }
    }

    @Override
    public List<TransactionService> getListOfTransactions() {
        return fruitTransactionListService;
    }
}
