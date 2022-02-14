package core.basesyntax.service.inter;

import java.util.List;

public interface ReadService {
    List<String> readFromFile(String filePath);
}
