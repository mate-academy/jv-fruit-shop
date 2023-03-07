package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface SaveService {
    List<FruitTransaction> saveToDb(List<String> string);
}
