package core.basesyntax.Service.FileWorkWith;

import core.basesyntax.Model.FruitTransaction;
import java.util.List;

public interface CSVFileWriterService {
    void writeToFile(String writeToFileName, List<FruitTransaction> data);
}
