package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.nio.file.Path;
import java.util.List;

public interface DailyReportFileReader {
    List<FruitTransaction> readDailyReport(Path filePath);
}
