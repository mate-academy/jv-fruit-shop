package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcess {
    List<FruitTransaction> dataProcessing(List<String> fileData);
}
