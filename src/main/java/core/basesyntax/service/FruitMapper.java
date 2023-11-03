package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> mapData(List<String> lines);
}
