package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    public List<FruitTransaction> parse(List<String> records);
}
