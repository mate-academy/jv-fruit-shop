package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface DataMapper {
    List<FruitTransaction> mapData(List<String> lines);
}
