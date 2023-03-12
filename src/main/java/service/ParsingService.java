package service;

import model.FruitTransaction;

public interface ParsingService {
    FruitTransaction parse(String line);
}
