package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface Constructor {
    Map<String, List<FruitTransaction>> processTheData(List<String> fromFile);
}
