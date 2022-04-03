package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface DataFromCsvFile {
    int OPERATION = 0;
    int FRUIT_NAME = 1;
    int QUANTITY = 2;
    List<FruitTransaction> readFileToList(String fileCsvPath);
}
