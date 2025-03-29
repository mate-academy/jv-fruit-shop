package service;

import model.FruitTransaction;

import java.util.List;

public interface ParserService {

    List<FruitTransaction> parseTransactions(List<String> stringList);
}