package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConvertService {
    List<FruitTransaction> convert(List<String> fruits);
}
