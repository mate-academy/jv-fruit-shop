package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverterService {
    List<FruitTransaction> convert(List<String> dataFromFile);
}
