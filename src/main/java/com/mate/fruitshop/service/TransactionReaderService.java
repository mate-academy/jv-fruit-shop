package com.mate.fruitshop.service;

import com.mate.fruitshop.model.Transaction;
import java.util.List;

public interface TransactionReaderService {
    List<Transaction> read(List<String> lines);
}
