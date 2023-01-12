package core.basesyntax.service.fileWorkWith;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CSVFileWriterService {
    void writeToFile(String writeToFileName, List<FruitTransaction> data);
}
