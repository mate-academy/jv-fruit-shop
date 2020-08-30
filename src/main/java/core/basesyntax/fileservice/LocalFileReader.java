package core.basesyntax.fileservice;

import java.util.List;

public interface LocalFileReader {
    List<List<String>> readFile(String[] filePath);
}
