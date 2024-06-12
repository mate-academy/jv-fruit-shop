package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface ReadingCsvFile {
    List<String> reading(String FileName);
}
