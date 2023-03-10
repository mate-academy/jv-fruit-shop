package com.mate.fruitshop.strategy;

import com.mate.fruitshop.model.Transaction;

public interface TransactionProcessingStrategy {
    boolean process(Transaction transaction);
}
