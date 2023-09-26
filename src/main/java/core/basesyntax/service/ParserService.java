package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parser(List<String> dataFromFile);
}
