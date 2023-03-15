package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface DataParser {
    public List<FruitTransaction> parseDataToFruitTransaction(List<String> data);
}
