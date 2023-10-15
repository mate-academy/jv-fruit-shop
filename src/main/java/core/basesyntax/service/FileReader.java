package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.File;
import java.util.ArrayList;

public interface FileReader {
    ArrayList<FruitTransaction> readFromFile(File file);
}
