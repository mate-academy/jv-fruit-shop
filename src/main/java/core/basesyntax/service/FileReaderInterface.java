package core.basesyntax.service;

import core.basesyntax.database.FruitActivity;
import java.util.List;

public interface FileReaderInterface {
    List<FruitActivity> readDataFromFile(String path);
}
