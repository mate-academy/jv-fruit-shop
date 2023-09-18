package core.basesyntax.service.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertService {
    public List<FruitTransaction> convertText(List<String> strings);
}
