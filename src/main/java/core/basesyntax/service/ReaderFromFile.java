package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface ReaderFromFile {
    List<String> read(File file);
}
