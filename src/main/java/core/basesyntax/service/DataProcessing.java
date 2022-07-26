package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import java.util.List;

public interface DataProcessing {
    FruitsDao processData(List<String> fileData);

    String getColumnsNamesLine();
}
