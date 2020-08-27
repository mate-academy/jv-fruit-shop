package core.basesyntax;

import java.util.List;

public interface FileReaderService {
    List<List<String>> readFile(String filePath, String separator);
}
