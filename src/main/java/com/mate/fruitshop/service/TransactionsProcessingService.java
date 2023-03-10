package com.mate.fruitshop.service;

import com.mate.fruitshop.model.Transaction;
import java.util.List;

public interface TransactionsProcessingService {
    boolean process(List<Transaction> transactions);
}
