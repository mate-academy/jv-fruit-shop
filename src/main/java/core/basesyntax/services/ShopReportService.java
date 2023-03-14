package core.basesyntax.services;

import java.nio.file.Path;

public interface ShopReportService {
    void createReport(Path inputDataPath, Path reportDataPath);
}
