package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface WriterToFile {
    void write(List<String> listReport, File file);
}
