package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataService {
    List<FruitTransaction> processData(List<String> activities);
}
