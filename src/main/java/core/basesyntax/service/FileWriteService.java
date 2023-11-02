package core.basesyntax.service;

import java.util.List;

public interface FileWriteService {
    void writeCvsToFile(List<String> text, String path);
}
