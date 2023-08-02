package core.basesyntax.service;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public interface DataFileParser {
    List<FruitTransaction> parse(List<String> rawData);
}
