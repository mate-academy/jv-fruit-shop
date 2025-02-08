package core.basesyntax.services;

import java.util.List;

public interface WriteService {
    void write(String filePath, List<String> data);
}
