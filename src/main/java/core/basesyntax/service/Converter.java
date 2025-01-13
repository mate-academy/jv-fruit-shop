package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface Converter {
    public List<FruitTransaction> convertToTransaction(List<String> transactions);
}
