package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseDataService {
    List<FruitTransaction> parseData(List<String> data);
}
