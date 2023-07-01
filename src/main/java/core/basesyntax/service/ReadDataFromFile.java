package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ReadDataFromFile {
    FruitTransaction readDataFromfile(String csvLine);
}
