package core.basesyntax.model;

import java.io.IOException;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> processFruitTransactions(String inputFileName) throws IOException;
}
