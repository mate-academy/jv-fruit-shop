package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileReaderService {
    public List<String> getDataFromFile(File file);
}
