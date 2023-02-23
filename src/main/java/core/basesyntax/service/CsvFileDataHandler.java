package core.basesyntax.service;

import java.util.List;

public interface CsvFileDataHandler {
    String HEADER = "fruit,quantity";

    void processData(List<String> fileData);
}
