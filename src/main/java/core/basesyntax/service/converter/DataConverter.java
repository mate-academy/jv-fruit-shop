package core.basesyntax.service.converter;

import core.basesyntax.FruitTransaction;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}

