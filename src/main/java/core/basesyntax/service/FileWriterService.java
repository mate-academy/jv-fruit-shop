package core.basesyntax.service;

import java.util.List;

public interface FileWriterService {
    void parse(List<String[]> report, String filePath);
}
