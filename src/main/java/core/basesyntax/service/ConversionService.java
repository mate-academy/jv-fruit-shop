package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConversionService {
    List<FruitTransaction> convert(List<String[]> data);
}
