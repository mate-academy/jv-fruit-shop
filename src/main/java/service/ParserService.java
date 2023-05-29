package service;

import model.Fruit;

public interface ParserService {
    Fruit getFruitFromCsvRow(String line);
}
