package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> mapData(List<String> list);
}
