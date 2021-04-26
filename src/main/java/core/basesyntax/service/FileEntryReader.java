package core.basesyntax.service;

import java.util.List;

public interface FileEntryReader {
    List<String> readFile(String path);
}
