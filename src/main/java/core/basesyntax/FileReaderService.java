package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<String> readData(String filePath) throws IOException;
}
