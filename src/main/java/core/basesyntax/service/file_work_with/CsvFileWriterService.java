package core.basesyntax.service.file_work_with;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvFileWriterService {
    void writeToFile(String writeToFileName, List<FruitTransaction> data);
}
