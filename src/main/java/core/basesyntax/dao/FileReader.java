package core.basesyntax.dao;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> read(String fileName) throws IOException;
}
