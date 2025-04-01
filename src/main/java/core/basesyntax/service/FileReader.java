package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String[]> processFile(String filePath) throws IOException;
}
