package core.basesyntax.service;

import core.basesyntax.model.FruitReport;
import java.util.List;

public interface Writer {

    void writeInFile(List<FruitReport> dataforReport, String filePath);
}
