package core.basesyntax.service;

import java.util.Map;

public interface Writer {
    void writeToFolder(Map<String, String> reports, String pathToFolder);
}
