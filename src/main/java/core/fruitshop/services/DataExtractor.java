package core.fruitshop.services;

import core.fruitshop.model.FruitTransaction;

public interface DataExtractor {
    FruitTransaction parse(String stringToParse);
}
