package core.basesyntax.service.cvs;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String filePath);
}
