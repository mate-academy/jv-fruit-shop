package service;

import model.FruitTransaction;

import java.util.List;

public interface TransactionParse {
    List<FruitTransaction> transactionParse(List<String> data);
}
