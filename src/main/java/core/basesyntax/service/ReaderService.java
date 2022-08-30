package core.basesyntax.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String fileName) throws FileNotFoundException;
}
