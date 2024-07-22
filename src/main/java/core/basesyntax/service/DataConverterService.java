package core.basesyntax.service;

import core.basesyntax.domain.FruitTransaction;
import java.util.List;

public interface DataConverterService {
    List<FruitTransaction> convertToFruit(List<String> inputReport);
}
