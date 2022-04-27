package core.basesyntax.service.writer;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface WriterService {
    void writeToFile(String outputFile, List<FruitTransaction> fruits);
}
