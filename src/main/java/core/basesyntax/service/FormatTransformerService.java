package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FormatTransformerService {
    List<FruitTransaction> formatData(List<String> data);
}
