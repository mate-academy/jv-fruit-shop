package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface Reader {
    List<String> ReadDataFromFileCSV(String file_csv);
}
