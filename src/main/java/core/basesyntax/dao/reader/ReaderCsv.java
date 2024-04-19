package core.basesyntax.dao.reader;

import java.nio.file.Path;
import java.util.List;

public interface ReaderCsv {
    List<String> read(Path fileName);
}
