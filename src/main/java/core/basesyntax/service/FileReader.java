package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileReader {
    List<String> readReport(File file);
}
