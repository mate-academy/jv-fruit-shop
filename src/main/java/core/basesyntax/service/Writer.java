package core.basesyntax.service;

import java.util.List;

public interface Writer {
    void write(List<String> reportData, String filePath);
}
