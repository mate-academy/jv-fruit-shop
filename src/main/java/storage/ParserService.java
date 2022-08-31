package storage;

import java.util.List;
import model.FruitTransaction;

public interface ParserService {
    List<FruitTransaction> getFruitsFromFile(List<String> info);
}
