package service;

import model.FruitTransaction;

import java.util.List;

public interface Reader {

    List<FruitTransaction> readTransactionsFromCsv(String fileName);
}
