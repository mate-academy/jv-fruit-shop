package core.basesyntax.service;

import java.util.List;

public interface ParserService {
    List<FruitTransaction> getObjectsFromStrings (List<String> strings);
}
