package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;
import service.TransactionCreatorService;

public class TransactionCreatorServiceImpl implements TransactionCreatorService {
    @Override
    public List<Transaction> creteTransactionsList(List<String> linesFromFile) {
        List<Transaction> transactionsList = new ArrayList<>();
        for (String line : linesFromFile) {
            Transaction newFruitTransactionService = new Transaction();
            newFruitTransactionService.createTransaction(line);
            transactionsList.add(newFruitTransactionService);
        }
        return transactionsList;
    }
}
