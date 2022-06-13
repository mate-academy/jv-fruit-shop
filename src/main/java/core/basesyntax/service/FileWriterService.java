package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileWriterService {
    void writeTheResult(File file, List<String[]> report);
}
