package core.basesyntax.fruitshop.service;

import java.io.IOException;
import java.util.List;

public interface ReaderService {
    List<String> readLines(String filePath) throws IOException;
}
