package core.basesyntax.service.readfromfileservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReadFromFileService {
    List<FruitTransaction> readFromCsvFile(String filePath);
}
