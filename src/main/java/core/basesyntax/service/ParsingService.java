package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface ParsingService {
    public List<FruitTransaction> parsingTransactions(List<String> list);
}
