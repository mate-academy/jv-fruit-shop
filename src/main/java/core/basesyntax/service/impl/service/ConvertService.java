package core.basesyntax.service.impl.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertService {
    List<FruitTransaction> convertData(List<String> strings);
}
