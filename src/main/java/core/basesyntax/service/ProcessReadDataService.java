package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessReadDataService {
    void addToDB(List<FruitTransaction> list);
}
