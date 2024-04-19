package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ParserCsv {
    List<FruitTransaction> parseTransactions(List<String> transactions);
}
