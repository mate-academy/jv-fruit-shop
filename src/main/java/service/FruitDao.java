package service;

import model.FruitTransaction;

public interface FruitDao {
    FruitTransaction getFromCsvData(String line);
}
