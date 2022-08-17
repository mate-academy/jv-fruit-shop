package core.basesyntax.service.csvfileservice;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String fileToRead);
}
