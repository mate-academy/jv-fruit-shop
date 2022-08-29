package core.basesyntax.service.impl;

import java.util.Map;

public interface FileWriterService {

    void write(String fileName, Map<String, Integer> fruitsQuantity);
}
