package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserReaderService {
    List<FruitTransaction> parse(List<String> listStringsFromFile);
}
