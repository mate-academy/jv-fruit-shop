package core.basesyntax.service;

import java.util.stream.Stream;

public interface FileReader {
    Stream<String> read(String path);
}
