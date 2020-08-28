package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<List<String>> readFile(String filePath);
}
