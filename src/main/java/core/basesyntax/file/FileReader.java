package core.basesyntax.file;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> readFile(String path) throws IOException;
}
