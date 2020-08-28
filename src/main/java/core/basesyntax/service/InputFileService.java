package core.basesyntax.service;

import java.util.List;

public interface InputFileService {
    List<List<String>> readFile(String filePath);
}
