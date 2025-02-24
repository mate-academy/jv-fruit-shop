package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> read(String filepath) throws IOException;
}
