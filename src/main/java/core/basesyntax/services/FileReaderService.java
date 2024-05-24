package core.basesyntax.services;

import java.io.File;
import java.util.List;

public interface FileReaderService {
    List<String> read(File file);
}
