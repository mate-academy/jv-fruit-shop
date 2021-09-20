package core.basesyntax.service.minorservices;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
