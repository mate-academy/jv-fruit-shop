package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessingFileDataService {
    List<FruitTransaction> processingFileData(List<String> fileLines);
}
