package shop.service;

import shop.impl.FruitTransaction;

public interface RowParser {
    FruitTransaction parseLine(String line);
}
