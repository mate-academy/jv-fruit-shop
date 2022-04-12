package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface CsvFileService {
    List<FruitTransaction> readFileToList(String fileCsvPath);
}
