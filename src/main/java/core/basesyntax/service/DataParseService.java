package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParseService {
    List<FruitTransaction> getParsedData(List<String> data);
}
