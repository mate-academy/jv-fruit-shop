package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseFile {
    List<FruitTransaction> parseData(List<String> data);
}
