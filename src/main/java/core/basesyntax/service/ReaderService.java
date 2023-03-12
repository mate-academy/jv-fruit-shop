package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    List<String> getDataFromCsv(String pathToResource);
}
