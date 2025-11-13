package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Converter {
    List<FruitTransaction> convert(List<String> lines);
}
