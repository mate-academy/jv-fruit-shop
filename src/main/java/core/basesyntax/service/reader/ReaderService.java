package core.basesyntax.service.reader;

import java.util.List;

public interface ReaderService {
    public List<String> readFromFile(String filePath);
}