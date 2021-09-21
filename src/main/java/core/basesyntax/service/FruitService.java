package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitService {
    void saveFruitRecordsFromFile(List<TransactionDto> fruitRecordsList);

    List<String> buildReportToList();
}
