package core.basesyntax.service.fileservice;

import java.util.List;

public interface FileReaderService {
    List<String> readFile(String path);
}
