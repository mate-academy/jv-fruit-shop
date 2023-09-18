package core.basesyntax.service.workwithfile;

import java.util.List;

public interface ReadFile {
    List<String> readFromCsvFile(String path);
}
