package core.basesyntax.service.cvs;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvParseService {
    List<FruitTransaction> getFruitsFromCsv(List<String> infoFromFile);
}
