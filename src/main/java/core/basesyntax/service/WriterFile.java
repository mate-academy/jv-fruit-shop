package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface WriterFile {
    void writeFile(List<String> report, File file);
}
