package service;

import model.FruitTransaction;

import java.util.List;

public interface FileParseService {
    List<FruitTransaction> parseTransactions(List<String> lines);
}
