package core.basesyntax.service.csvService;

import java.util.List;

public interface ReaderService {
    List<String> read(String filePath);
}
