package core.basesyntax.filereader;

import java.util.List;

public interface FileReaderService {
    List<List<String>> readFile(String filePath);
}
