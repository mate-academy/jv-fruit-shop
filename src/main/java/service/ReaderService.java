package service;

import java.nio.file.Path;
import java.util.List;
import model.FruitTransaction;

public interface ReaderService {
    List<FruitTransaction> read(Path path);
}
