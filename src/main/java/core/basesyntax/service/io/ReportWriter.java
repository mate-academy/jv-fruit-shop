package core.basesyntax.service.io;

import java.nio.file.Path;
import java.util.List;

public interface ReportWriter {
    void writeReport(Path pathToFile, List<String[]> report);
}
