package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverterService {
    public List<FruitTransaction> convertText(List<String> strings);
}
