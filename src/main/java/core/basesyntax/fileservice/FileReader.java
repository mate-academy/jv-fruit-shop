package core.basesyntax.fileservice;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String filePath);
}
