package core.basesyntax.service.file.work;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvFileWriterService {
    void writeToFile(String writeToFileName, List<FruitTransaction> data);
}
