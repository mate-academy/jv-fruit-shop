package core.basesyntax.service;

import core.basesyntax.model.FruitItem;
import java.util.List;

public interface FruitReportFileWriter {
    void write(String fileName, List<FruitItem> fruitItems);
}
