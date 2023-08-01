package core.basesyntax.service;

import java.util.List;

public interface WriteService {
    void writeToFile(List<String> data, String path);
}
