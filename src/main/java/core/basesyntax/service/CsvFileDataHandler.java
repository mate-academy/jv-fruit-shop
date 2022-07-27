package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import java.util.List;

public interface CsvFileDataHandler {
    String COLUMNS_NAMES_LINE = "type,fruit,quantity";

    FruitsDao processData(List<String> fileData);
}
