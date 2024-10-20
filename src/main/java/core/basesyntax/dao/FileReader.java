package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FileReader {
    List<String> read(String filename);
}
