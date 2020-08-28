package core.basesyntax.service;

import java.util.Map;

public interface FileWriterService {
    void write(Map<String, Integer> data, String fileName);
}
