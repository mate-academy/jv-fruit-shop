package core.basesyntax.service;

import java.util.List;

public interface Convertable {
    List<CsvConverter.OperationData> convertToRecord(String dataFromFile);
}
