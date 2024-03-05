package service;

import core.basesyntax.FruitTransaction;

import java.util.List;

public interface CSVReader {
    List<String> readTransactions(String filePath);
}
