package core.basesyntax.service.csvfileservice;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String pathToFile);
}
