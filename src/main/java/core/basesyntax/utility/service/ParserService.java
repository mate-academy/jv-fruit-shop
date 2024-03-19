package core.basesyntax.utility.service;

import core.basesyntax.utility.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parseData(List<String> data);
}
