package core.basesyntax.fileservice;

import java.util.List;

public interface FileRead {
    List<List<String>> readFile(String[] filePath);
}
