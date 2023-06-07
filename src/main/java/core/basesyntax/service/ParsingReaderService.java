package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParsingReaderService {
    List<FruitTransaction> getParsingValueFromFile(List<String> listStringsFromFile);
}
