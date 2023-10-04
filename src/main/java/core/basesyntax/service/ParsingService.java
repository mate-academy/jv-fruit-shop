package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParsingService {
    List<FruitTransaction> parsingDataFromListOfStrings(List<String> list);
}
