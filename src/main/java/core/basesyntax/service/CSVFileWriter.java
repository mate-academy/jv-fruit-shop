package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface CSVFileWriter {
    public void writeFile(List<String> lines, String fileName);
}
