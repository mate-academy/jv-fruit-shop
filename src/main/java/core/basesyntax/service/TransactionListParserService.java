package core.basesyntax.service;

import core.basesyntax.strategy.FruitTransaction;
import java.util.List;

public interface TransactionListParserService {
    List<FruitTransaction> parse(List<String> input);
}
