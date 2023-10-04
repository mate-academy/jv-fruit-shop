package core.basesyntax.service;

import java.io.File;

public interface WriterService {
    void writeDataToFile(File toFileName, String report);
}
