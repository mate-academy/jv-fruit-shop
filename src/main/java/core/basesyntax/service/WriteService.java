package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.io.File;
import java.util.List;

public interface WriteService {
    void writeFile(List<FruitTransaction> transactions, File toFile);
}
