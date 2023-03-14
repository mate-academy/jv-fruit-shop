package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransform {
    List<FruitTransaction> transform(List<String> strings);
}
