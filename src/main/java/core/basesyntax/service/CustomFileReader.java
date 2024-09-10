package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface CustomFileReader {
    List<String> read(String path) throws IOException;
}
