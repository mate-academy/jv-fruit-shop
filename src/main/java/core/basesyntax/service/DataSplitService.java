package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface DataSplitService {
    List<FruitTransaction> splitData(String data);
}
