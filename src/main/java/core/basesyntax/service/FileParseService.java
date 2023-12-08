package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileParseService {

    List<FruitTransaction> parseDataFromCV(List<String> dataFromFile);
}
