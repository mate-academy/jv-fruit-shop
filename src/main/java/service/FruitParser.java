package service;

import model.FruitTransaction;

public interface FruitParser {
    FruitTransaction getFromCsvRow(String stringList);
}
