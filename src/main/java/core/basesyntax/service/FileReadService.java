package core.basesyntax.service;

import java.util.List;

public interface FileReadService {
    List<String> readFromFile(String path);
}
