package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessDataService {
    List<String> readData(String filePath);

    List<FruitTransaction> saveData(List<String> inputData);
}
