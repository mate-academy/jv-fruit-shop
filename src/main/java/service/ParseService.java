package service;

import model.FruitTransaction;

public interface ParseService {

    FruitTransaction parseLine(String line);
}
