package com.mate.fruitshop.strategy;

import com.mate.fruitshop.model.Transaction;

public interface TransactionProcessingStrategy {
    void process(Transaction transaction);
}
