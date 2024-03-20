package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    boolean writeTo(String filePath, List<String> rows);
}
