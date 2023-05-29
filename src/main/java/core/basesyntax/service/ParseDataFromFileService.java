package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseDataFromFileService {
    List<FruitTransaction> parseData(List<String> lines);
}
