package core.fruitshop.service;

import core.fruitshop.model.FruitTransaction;

public interface DataParser {
    FruitTransaction parse(String stringToParse);
}
