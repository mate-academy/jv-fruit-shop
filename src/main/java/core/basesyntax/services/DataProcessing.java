package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface DataProcessing {
    List<FruitTransaction> processData(List<String> enterList);
}
