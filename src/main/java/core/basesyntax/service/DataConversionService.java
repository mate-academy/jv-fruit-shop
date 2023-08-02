package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConversionService {
    List<FruitTransaction> convert(String rawData);
}
