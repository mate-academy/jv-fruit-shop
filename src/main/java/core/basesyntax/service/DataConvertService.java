package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface DataConvertService {
    List<FruitTransaction> convertTransactions(List<String> lines);
}
