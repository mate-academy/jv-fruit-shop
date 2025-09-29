package core.basesyntax.io;

import java.io.File;
import java.util.List;

public interface FileReader {
    List<String> read(File input);
}
