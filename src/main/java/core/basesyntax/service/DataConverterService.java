package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverterService {
    List<FruitTransaction> getListOfTransactions(List<String> lines);
}
