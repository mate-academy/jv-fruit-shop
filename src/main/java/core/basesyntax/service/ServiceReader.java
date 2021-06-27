package core.basesyntax.service;

import java.util.List;

public interface ServiceReader {
    List<String> readFile(String filePath);
}
