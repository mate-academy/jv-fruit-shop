package core.basesyntax.service;

import java.util.List;

public interface FileLinesReader {
    List<String> dataFromFile(String fileName);
}
