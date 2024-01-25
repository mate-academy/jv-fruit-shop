package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parseTransactions(List<String> lines);
}
