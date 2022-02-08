package shop.service;

import shop.impl.FruitTransaction;

public interface Parser {
    FruitTransaction parseLine(String line);
}