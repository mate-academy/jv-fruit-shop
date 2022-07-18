package core.basesyntax.service;

import java.util.List;

public interface PivotFileWriterService {
    void exportPivotToFile(List<String> report);
}
