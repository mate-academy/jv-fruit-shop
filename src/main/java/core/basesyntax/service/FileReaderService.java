package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<String> read(String filePath) throws IOException;
}
