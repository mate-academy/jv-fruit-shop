package core.basesyntax.service.fileservices;

import java.util.List;

public interface ReadFile {
    List<String> readFromCsvFile(String path);
}
