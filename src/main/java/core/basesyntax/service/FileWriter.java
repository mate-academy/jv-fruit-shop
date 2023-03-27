package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeIntoFile(List<String> listData, String path);
}
