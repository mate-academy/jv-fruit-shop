package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertFileToList {
    List<FruitTransaction> convert(List<String> list);
}
