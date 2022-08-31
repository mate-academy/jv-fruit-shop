package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.Strategy;
import java.util.List;
import java.util.Map;

public interface ParserService {
    List<Transaction> parse(List<String> list);
}
