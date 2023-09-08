package service;

import java.util.List;
import model.Transaction;

public interface TransactionConverter {
    List<Transaction> convertToTransactionList(List<String[]> dataFromFile);
}

