package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    void readFromFile(String inputFile);

    List<String> getData();
}
