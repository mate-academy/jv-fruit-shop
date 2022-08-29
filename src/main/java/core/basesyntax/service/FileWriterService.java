package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileWriterService {
    void writeReport(File outputFile, List<String> strings);
}
