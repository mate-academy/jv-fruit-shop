package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileConverter {
    List<FruitTransaction> convertToObjects(List<String> data);
}
