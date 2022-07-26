package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parseDatabaseInfo(List<String[]> info);
}
