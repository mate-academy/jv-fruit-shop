package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ParseCsvService {
    void getTransactions(List<String> strings);
}
