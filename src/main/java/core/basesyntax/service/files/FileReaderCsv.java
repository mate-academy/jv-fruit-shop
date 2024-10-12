package core.basesyntax.service.files;

import java.util.List;

public interface FileReaderCsv {
    List<String> read(String filePath);
}
