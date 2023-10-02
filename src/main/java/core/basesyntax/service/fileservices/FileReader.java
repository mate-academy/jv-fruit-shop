package core.basesyntax.service.fileservices;

import java.util.List;

public interface FileReader {
    List<String> readFromCsvFile(String path);
}
