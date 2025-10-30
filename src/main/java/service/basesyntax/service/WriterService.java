package service.basesyntax.service;

import java.util.Map;

public interface WriterService {
    void write(Map<String, Integer> storage, String path);
}
