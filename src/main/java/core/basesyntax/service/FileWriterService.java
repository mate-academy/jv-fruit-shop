package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileWriterService {
    void write(File file, List<String[]> report);
}
