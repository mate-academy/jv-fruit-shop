package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParserService {
    public List<FruitTransaction> parseDataToFruitTransaction(List<String> data);
}
