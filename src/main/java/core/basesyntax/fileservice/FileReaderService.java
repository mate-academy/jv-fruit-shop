package core.basesyntax.fileservice;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String path);
}
