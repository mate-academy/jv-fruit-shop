package core.basesyntax.service;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> parse(List<String> data);
}
