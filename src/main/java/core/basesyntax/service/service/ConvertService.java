package core.basesyntax.service.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertService {
    public List<FruitTransaction> proccesing(List<String> strings);
}
