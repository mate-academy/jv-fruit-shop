package core.basesyntax.service;

import java.util.stream.Stream;

public interface ReaderService {
    Stream<String> readFromFile(String filePath);
}
