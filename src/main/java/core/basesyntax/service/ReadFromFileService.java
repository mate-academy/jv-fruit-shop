package core.basesyntax.service;

import java.util.List;

public interface ReadFromFileService {
    List<String> readCsv(String path);
}
